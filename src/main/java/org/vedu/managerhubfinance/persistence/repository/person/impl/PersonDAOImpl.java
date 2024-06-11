package org.vedu.managerhubfinance.persistence.repository.person.impl;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.groupperson.Person;
import org.vedu.managerhubfinance.persistence.model.groupperson.PersonContact;
import org.vedu.managerhubfinance.persistence.model.groupperson.PersonPhone;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.person.PersonDAO;

import jakarta.persistence.LockModeType;
import jakarta.persistence.TypedQuery;

public class PersonDAOImpl extends CrudRepositoryImpl<Long, Person> implements PersonDAO<Long, Person>{

	public PersonDAOImpl() {
		super(Person.class);
	}
	
	@Override
	public Person findByNameAndType(String name, String type) {
		TypedQuery<Person> query = 
				getEm()
				.createQuery(
						"SELECT p FROM Person p WHERE p.name = :name AND p.type = :type",
						Person.class);
		query.setParameter("name", name);
		query.setParameter("type", type);
		query.setLockMode(LockModeType.NONE);
		return query.getSingleResult();
	}

	@Override
	public Person findByNameAndType(String name, String type, LockModeType lockModeType) {
		TypedQuery<Person> query = 
				getEm()
				.createQuery(
						"SELECT p FROM Person p WHERE p.name = :name AND p.type = :type",
						Person.class);
		query.setParameter("name", name);
		query.setParameter("type", type);
		query.setLockMode(lockModeType);
		return query.getSingleResult();
	}

	@Override
	public List<Person> findListByType(String type) {
		TypedQuery<Person> query = 
				getEm()
				.createQuery(
						"SELECT p FROM Person p WHERE p.type = :type",
						Person.class);
		query.setParameter("type", type);
		query.setLockMode(LockModeType.NONE);
		return query.getResultList();
	}

	@Override
	public List<Person> findListByType(String type, LockModeType lockModeType) {
		TypedQuery<Person> query = 
				getEm()
				.createQuery(
						"SELECT p FROM Person p WHERE p.type = :type",
						Person.class);
		query.setParameter("type", type);
		query.setLockMode(lockModeType);
		return query.getResultList();
	}

	@Override
	public List<? extends PersonContact> findListContact(String contactName, Long idPerson) {
		TypedQuery<? extends PersonContact> query = 
				getEm()
				.createQuery(
				"SELECT pc FROM PersonContact pc WHERE pc.name = :name AND pc.person.id = :idPerson",
				PersonContact.class);
		query.setParameter("name", contactName);
		query.setParameter("idPerson", idPerson);
		query.setLockMode(LockModeType.NONE);
		List<? extends PersonContact> result = query.getResultList();
		return result;
	}

	@Override
	public List<?> findListPhone(String phoneType, Long idPerson) {
		TypedQuery<? extends PersonPhone> query = 
                getEm()
                .createQuery(
                "SELECT pp FROM PersonPhone pp WHERE pp.type = :type AND pp.person.id = :idPerson",
                PersonPhone.class);
        query.setParameter("type", phoneType);
        query.setParameter("idPerson", idPerson);
        query.setLockMode(LockModeType.NONE);
        List<? extends PersonPhone> result = query.getResultList();
        return result;
	}

	public static PersonDAOImpl getInstance() {
		return new PersonDAOImpl();
	}
}
