package org.vedu.managerhubfinance.persistence.repository.person;

import org.vedu.managerhubfinance.persistence.model.groupperson.Carrier;
import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface CarrierDAO extends CrudRepository<Long, Carrier> {
	
}
