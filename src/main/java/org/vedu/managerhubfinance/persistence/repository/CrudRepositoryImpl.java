package org.vedu.managerhubfinance.persistence.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.Data;

@Data
public abstract class CrudRepositoryImpl<ID extends Serializable, E> implements CrudRepository<ID, E> {

	@PersistenceContext
	private EntityManager em;
	
	protected final Class<E> entityClass;
	
	protected CrudRepositoryImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public Optional<E> findSingleEntity(ID key) {
		em.setFlushMode(FlushModeType.AUTO);
		return Optional.ofNullable(em.find(entityClass, key, LockModeType.NONE));
	}

	@Override
	public Optional<E> findSingleEntity(ID key, LockModeType lockMode) {
		em.setFlushMode(FlushModeType.AUTO);
		return Optional.ofNullable(em.find(entityClass, key, lockMode));
	}

	@Override
	public List<E> findListEntity() {
		return em
				.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass)
				.setLockMode(LockModeType.NONE)
				.setFlushMode(FlushModeType.AUTO)
				.getResultList();
	}
	
	@Override
	public List<E> findListEntity(LockModeType lockMode) {
		return em
				.createQuery("SELECT e FROM " + entityClass.getName() + " e", entityClass)
				.setLockMode(lockMode)
				.setFlushMode(FlushModeType.AUTO)
				.getResultList();
	}

	@Override
	public E findSingleReference(ID key) {
		return em.getReference(entityClass, key);
	}
	
	public Long getCount() {
		CriteriaQuery<Long> c = em.getCriteriaBuilder().createQuery(Long.class);
		c.select(em.getCriteriaBuilder().count(c.from(entityClass)));
		return em.createQuery(c).getSingleResult();
	}

	@Override
	public void save(E entity) {
		em.persist(entity);
	}

	@Override
	public void saveAll(List<E> entities) {
		entities.forEach(em::persist);
	}

	@Override
	public void makePersistent(E entity) {
		em.merge(entity);
	}

	@Override
	public void makePersistentAll(List<E> entities) {
		entities.forEach(em::merge);
	}

	@Override
	public void makeTransient(E entity) {
		em.remove(entity);
	}

	@Override
	public void makeTransientAll(List<E> entities) {
		entities.forEach(em::remove);
	}

	@Override
	public void checkVersion(E entity, boolean forceUpdate) {
		em.lock(entity, 
				forceUpdate ? LockModeType.OPTIMISTIC_FORCE_INCREMENT :
				LockModeType.OPTIMISTIC);
	}
}
