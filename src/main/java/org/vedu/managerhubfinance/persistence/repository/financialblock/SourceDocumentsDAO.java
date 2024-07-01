package org.vedu.managerhubfinance.persistence.repository.financialblock;

import org.vedu.managerhubfinance.persistence.model.financialblock.FinSourceDocuments;
import org.vedu.managerhubfinance.persistence.repository.CrudRepository;

import jakarta.ejb.Local;

@Local
public interface SourceDocumentsDAO extends CrudRepository<Long, FinSourceDocuments> {
	public FinSourceDocuments findByCode(String code);
}
