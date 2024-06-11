package org.vedu.managerhubfinance.persistence.repository.base;

import jakarta.persistence.LockModeType;

public interface CityDAO<ID, E> {
	public E findByName(String name);
	public E findByName(String name, LockModeType lockModeType);
}
