package org.vedu.managerhubfinance.service.person;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.groupperson.Person;

import jakarta.persistence.LockModeType;

public interface PersonService {
	
	public Person findByNameAndType(String name, String type);
	public Person findByNameAndType(String name, String type, LockModeType lockModeType);
	public List<Person> findListByType(String type);
	public List<Person> findListByType(String type, LockModeType lockModeType);
	

}
