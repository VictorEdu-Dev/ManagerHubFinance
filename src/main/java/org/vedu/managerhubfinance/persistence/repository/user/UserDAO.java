package org.vedu.managerhubfinance.persistence.repository.user;

import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

public interface UserDAO<ID, E> extends CrudRepository<ID, E> {
	public E findByUsername(ID username);
}
