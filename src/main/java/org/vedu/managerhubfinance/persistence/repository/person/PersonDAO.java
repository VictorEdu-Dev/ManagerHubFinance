package org.vedu.managerhubfinance.persistence.repository.person;

import java.util.List;

import jakarta.persistence.LockModeType;

public interface PersonDAO<ID, E> {
	public E findByNameAndType(String name, String type);
	public E findByNameAndType(String name, String type, LockModeType lockModeType);
	public List<E> findListByType(String type);
	public List<E> findListByType(String type, LockModeType lockModeType);
	public List<?> findListContact(String contactName, ID idPerson);
	public List<?> findListPhone(String phoneType, ID idPerson);
}
