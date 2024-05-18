package org.vedu.managerhubfinance.persistence.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.model.persongroup.Person;
import org.vedu.managerhubfinance.service.impl.RepositoryTransaction;

import jakarta.persistence.LockModeType;

public class PersonDao implements CrudRepository<Integer, Person>, CrudTransaction<Integer, Person> {
	private RepositoryTransaction<Integer, Person> repositoryTransaction;
	
	public PersonDao() {
		this.repositoryTransaction = new RepositoryTransaction<Integer, Person>();
	}
	
	public RepositoryTransaction<Integer, Person> getTransaction() {
		return repositoryTransaction;
	}
	
	@Override
	public Person findSingleEntity(Integer key, Class<Person> entity) {
		Optional<List<Person>> result = getTransaction()
				.executeFindInTransaction(em -> 
				Collections.singletonList(em.find(entity, key, LockModeType.OPTIMISTIC)));
		return result.flatMap(list -> list.stream().findFirst()).orElse(null);
	}

	@Override
	public List<Person> findListEntity(Class<Person> entity) {
		Optional<List<Person>> result = getTransaction()
				.executeFindInTransaction(em -> em
						.createQuery("SELECT p FROM Person p", Person.class)
						.setLockMode(LockModeType.PESSIMISTIC_READ)
						.getResultList());
		return result.orElse(Collections.emptyList());
	}

	@Override
	public void save(Person entity) {
		getTransaction().executeSaveInTransaction(em -> {
			em.lock(entity, LockModeType.PESSIMISTIC_WRITE);
			em.persist(entity);
			});
	}

	@Override
	public void saveAll(List<Person> entities) {
		getTransaction().executeSaveInTransaction(em -> {
		entities.forEach(entity -> {
            em.lock(entity, LockModeType.PESSIMISTIC_WRITE);
            em.persist(entity);
            });
		});
	}

	@Override
	public void update(Person entity) {
		getTransaction().executeUpdateInTransaction(em -> {
			em.merge(entity);
			});
	}

	@Override
	public void updateAll(List<Person> entities) {
		getTransaction().executeUpdateInTransaction(em -> {
		entities.forEach(em::merge);
		});
	}

	@Override
	public void delete(Person entity) {
		getTransaction().executeDeleteInTransaction(em -> {
			em.lock(entity, LockModeType.PESSIMISTIC_WRITE);
			em.remove(entity);
		});
	}

	@Override
	public void deleteAll(List<Person> entities) {
		getTransaction().executeDeleteInTransaction(em -> {
				entities.forEach(entity -> {
	            em.lock(entity, LockModeType.PESSIMISTIC_WRITE);
	            em.remove(entity);
	        });
		});
	}

}
