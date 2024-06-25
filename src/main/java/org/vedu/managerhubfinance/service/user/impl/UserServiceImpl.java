package org.vedu.managerhubfinance.service.user.impl;

import org.vedu.managerhubfinance.persistence.model.user.Admin;
import org.vedu.managerhubfinance.persistence.repository.user.UserDAO;
import org.vedu.managerhubfinance.service.user.UserService;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class UserServiceImpl implements UserService {

	@EJB
	UserDAO<String, Admin> userDAO;
	
	@Override
	public Admin getUser() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public Admin getUserById(String id) {
		return userDAO.findByUsername(id);
	}

	public void createUser(Admin user) {
		userDAO.save(user);
	}

	public void updateUser(Admin user) {
		userDAO.makePersistent(user);
	}

	public void deleteUser(Admin id) {
		userDAO.makeTransient(id);
	}

}
