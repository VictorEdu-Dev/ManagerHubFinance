package org.vedu.managerhubfinance.persistence.repository.person;

import java.util.List;

import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.persistence.LockModeType;

public interface PersonDAO<ID, E> extends CrudRepository<ID, E> {
	public E findByNameAndType(String name, String type);
	public E findByNameAndType(String name, String type, LockModeType lockModeType);
	public List<E> findListByType(String type);
	public List<E> findListByType(String type, LockModeType lockModeType);
	public List<?> findListContact(String contactName, ID idPerson);
}
