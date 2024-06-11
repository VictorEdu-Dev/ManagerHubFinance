package org.vedu.managerhubfinance.persistence.repository.base.impl;

import org.vedu.managerhubfinance.persistence.model.groupbasic.City;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.base.CityDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CityDAOImpl extends CrudRepositoryImpl<String, City> implements CityDAO<String, City> {
	
	@PersistenceContext
	private EntityManager em;
	
	public CityDAOImpl(EntityManager em) {
		super(City.class);
		this.em = em;
	}

	@Override
	public City findByName(String name) {
		String query = "SELECT c FROM City c WHERE c.name = :name";
	    return em
	    		.createQuery(query, City.class)
	    		.setParameter("name", name)
	    		.getSingleResult();
	}

	@Override
	public City findByName(String name, LockModeType lockModeType) {
		throw new UnsupportedOperationException();
	}
	
}
