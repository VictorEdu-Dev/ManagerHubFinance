package org.vedu.managerhubfinance.persistence.repository.person.impl;

import org.vedu.managerhubfinance.persistence.model.groupperson.Accountant;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.person.AccountantDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class AccountantDAOImpl extends CrudRepositoryImpl<Long, Accountant> implements AccountantDAO {

	protected AccountantDAOImpl() {
		super(Accountant.class);
	}

	@Override
	public Accountant findByCrc(String crc) {
		TypedQuery<Accountant> result = getEntityManager()
				.createQuery("SELECT a FROM Accountant a WHERE a.crc = :crc", entityClass)
				.setParameter("crc", crc);
		return result.getSingleResult();
	}

}
