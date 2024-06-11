package org.vedu.managerhubfinance.persistence.repository.base;

import java.util.List;
import java.util.Optional;

public interface CepDAO<ID, E> {
	public List<E> findAll(boolean withCity);
	public List<E> findByName(String name, boolean subtring);
	public Optional<E> findByStreet(String street);
	public void makeTransientById(ID id);
}
