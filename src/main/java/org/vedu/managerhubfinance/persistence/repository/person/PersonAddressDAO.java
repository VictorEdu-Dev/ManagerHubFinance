package org.vedu.managerhubfinance.persistence.repository.person;

import org.vedu.managerhubfinance.persistence.model.groupperson.PersonAddress;
import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface PersonAddressDAO extends CrudRepository<Long, PersonAddress> {
	
	
}
