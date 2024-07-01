package org.vedu.managerhubfinance.persistence.repository.person;

import org.vedu.managerhubfinance.persistence.model.groupperson.EducationLevel;
import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface EducationLevelDAO extends CrudRepository<Long, EducationLevel> {
	EducationLevel findByName(String name);
}
