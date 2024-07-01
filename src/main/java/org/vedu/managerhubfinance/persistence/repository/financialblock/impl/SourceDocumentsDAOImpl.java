package org.vedu.managerhubfinance.persistence.repository.financialblock.impl;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinSourceDocuments;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.financialblock.SourceDocumentsDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;

@Stateless
public class SourceDocumentsDAOImpl extends CrudRepositoryImpl<Long, FinSourceDocuments> implements SourceDocumentsDAO {

	protected SourceDocumentsDAOImpl() {
		super(FinSourceDocuments.class);
	}

	@Override
	public FinSourceDocuments findByCode(String code) {
		TypedQuery<FinSourceDocuments> result = getEntityManager()
				.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE e.code = :code", entityClass)
				.setParameter("code", code);
		return result.getSingleResult();
	}

}
