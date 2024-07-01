package org.vedu.managerhubfinance.persistence.repository.person.impl;

import org.vedu.managerhubfinance.persistence.model.groupperson.EducationLevel;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.person.EducationLevelDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class EducationLevelDAOImpl extends CrudRepositoryImpl<Long, EducationLevel> implements EducationLevelDAO {
	
	protected EducationLevelDAOImpl() {
		super(EducationLevel.class);
	}

	@Override
	public EducationLevel findByName(String name) {
		TypedQuery<EducationLevel> result = getEntityManager()
				.createQuery("SELECT e FROM EducationLevel e WHERE e.name = :name", EducationLevel.class)
				.setParameter("name", name);
		return result.getSingleResult();
	}
}
