package org.vedu.managerhubfinance.service.user;

import org.vedu.managerhubfinance.persistence.model.user.Admin;

import jakarta.ejb.Local;

@Local
public interface UserService {
	public Admin getUser();
	public Admin getUserById(String id);
	public void createUser(Admin user);
	public void updateUser(Admin user);
	public void deleteUser(Admin id);
}
