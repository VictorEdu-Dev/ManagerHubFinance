package org.vedu.managerhubfinance.persistence.repository.person;

import org.vedu.managerhubfinance.persistence.model.groupperson.Accountant;
import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface AccountantDAO extends CrudRepository<Long, Accountant> {

	public Accountant findByCrc(String crc);

}
