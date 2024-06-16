package org.vedu.managerhubfinance.service.basic.impl;

import java.util.Map;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.model.groupbasic.City;
import org.vedu.managerhubfinance.persistence.model.groupbasic.State;
import org.vedu.managerhubfinance.persistence.repository.base.CepDAO;
import org.vedu.managerhubfinance.persistence.repository.base.CityDAO;
import org.vedu.managerhubfinance.persistence.repository.base.StateDAO;
import org.vedu.managerhubfinance.service.basic.BasicService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class BasicAdminImpl implements BasicService {
	
	@EJB
	private StateDAO<String, State> stateDAO;
	
	@EJB
	private CityDAO<String, City> cityDAO;
	
	@EJB
	private CepDAO<String, Cep> cepDAO;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<String> getNumberCep(Map<String, String> properties) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Integer> getStateCode(String stateName) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<String> getCityName(String cep) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Map<String, String>> getAddressInfo(String cepNumber) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@RolesAllowed("ADMIN")
	public void editCepInfo(Cep cep) {
		if (cep == null)
			throw new IllegalArgumentException("Cep não pode ser nulo.");
		else
			cepDAO.makePersistent(cep);
	}

	@Override
	public void destruct() {
		// TODO Auto-generated method stub
		
	}

}
