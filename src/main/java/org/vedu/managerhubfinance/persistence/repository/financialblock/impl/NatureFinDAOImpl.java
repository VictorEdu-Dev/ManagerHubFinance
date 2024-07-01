package org.vedu.managerhubfinance.persistence.repository.financialblock.impl;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFin;
import org.vedu.managerhubfinance.persistence.model.financialblock.FinNatureFinEnum;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.financialblock.NatureFinDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class NatureFinDAOImpl extends CrudRepositoryImpl<Long, FinNatureFin> implements NatureFinDAO {

	protected NatureFinDAOImpl() {
		super(FinNatureFin.class);
	}

	@Override
	public FinNatureFin getNatureFinByType(FinNatureFinEnum type) {
		TypedQuery<FinNatureFin> tq = getEntityManager()
				.createQuery("SELECT nf FROM FinNatureFin nf WHERE nf.type = :type", FinNatureFin.class); 
		tq.setParameter("type", type);
		return tq.getSingleResult();
	}
	
	

}
