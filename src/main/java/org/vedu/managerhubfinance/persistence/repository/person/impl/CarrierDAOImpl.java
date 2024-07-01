package org.vedu.managerhubfinance.persistence.repository.person.impl;



import org.vedu.managerhubfinance.persistence.model.groupperson.Carrier;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.person.CarrierDAO;

import jakarta.ejb.Stateless;

@Stateless
public class CarrierDAOImpl extends CrudRepositoryImpl<Long, Carrier> implements CarrierDAO  {

	protected CarrierDAOImpl() {
		super(Carrier.class);
	}

}
