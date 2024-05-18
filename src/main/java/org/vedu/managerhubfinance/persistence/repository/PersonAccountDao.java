package org.vedu.managerhubfinance.persistence.repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.model.PersonAccount;
import org.vedu.managerhubfinance.persistence.model.PersonAccountId;
import org.vedu.managerhubfinance.service.impl.RepositoryTransaction;

import jakarta.persistence.LockModeType;

public class PersonAccountDao implements CrudTransaction<PersonAccountId, PersonAccount>,
CrudRepository<PersonAccountId, PersonAccount> {
	private RepositoryTransaction<PersonAccountId, PersonAccount> repositoryTransaction;
	
	public PersonAccountDao() {
		this.repositoryTransaction = new RepositoryTransaction<PersonAccountId, PersonAccount>();
	}

	@Override
	public PersonAccount findSingleEntity(PersonAccountId key, Class<PersonAccount> entity) {
		Optional<List<PersonAccount>> result = getTransaction()
				.executeFindInTransaction(em -> 
				Collections.singletonList(em.find(entity, key, LockModeType.OPTIMISTIC)));
		return result.flatMap(list -> list.stream().findFirst()).orElse(null);
	}

	@Override
	public List<PersonAccount> findListEntity(Class<PersonAccount> entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(PersonAccount entity) {
		getTransaction().executeSaveInTransaction(em -> em.persist(entity));
	}

	@Override
	public void saveAll(List<PersonAccount> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(PersonAccount entity) {
		getTransaction().executeUpdateInTransaction(em -> em.merge(entity));
	}

	@Override
	public void updateAll(List<PersonAccount> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(PersonAccount entity) {
		getTransaction().executeDeleteInTransaction(em -> em.remove(entity));
	}

	@Override
	public void deleteAll(List<PersonAccount> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public RepositoryTransaction<PersonAccountId, PersonAccount> getTransaction() {
		return repositoryTransaction;
	}
	
	
}
