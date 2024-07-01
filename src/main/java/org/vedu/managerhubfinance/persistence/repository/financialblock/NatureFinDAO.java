package org.vedu.managerhubfinance.persistence.repository.financialblock;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFin;
import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFinEnum;
import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface NatureFinDAO extends CrudRepository<Long, FinNatureFin> {
	public FinNatureFin getNatureFinByType(FinNatureFinEnum type);
}
