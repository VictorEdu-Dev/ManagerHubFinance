package org.vedu.managerhubfinance.persistence.repository.user.impl;

import org.vedu.managerhubfinance.persistence.model.user.Admin;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.user.UserDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class UserDAOImpl extends CrudRepositoryImpl<String, Admin> implements UserDAO<String, Admin> {

	UserDAOImpl() {
		super(Admin.class);
	}
	
	@Override
	public Admin findByUsername(String username) {
		TypedQuery<Admin> query = getEntityManager()
				.createQuery("SELECT a FROM Admin a WHERE a.username = :username", Admin.class)
				.setParameter("username", username);
		return query.getSingleResult();
	}

}
