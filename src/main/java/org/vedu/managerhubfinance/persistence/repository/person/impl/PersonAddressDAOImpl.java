package org.vedu.managerhubfinance.persistence.repository.person.impl;

import org.vedu.managerhubfinance.persistence.model.groupperson.PersonAddress;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.person.PersonAddressDAO;

import jakarta.ejb.Stateless;

@Stateless
public class PersonAddressDAOImpl extends CrudRepositoryImpl<Long, PersonAddress> implements PersonAddressDAO {

	protected PersonAddressDAOImpl() {
		super(PersonAddress.class);
	}

}
