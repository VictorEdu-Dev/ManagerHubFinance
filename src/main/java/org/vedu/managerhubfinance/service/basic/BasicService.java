package org.vedu.managerhubfinance.service.basic;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.repository.base.impl.CepDAOImpl;

import jakarta.persistence.EntityManager;
import lombok.Data;

@Data
public class BasicService {
	private CepDAOImpl  cepDAO;
	
	public BasicService(EntityManager em) {
		this.cepDAO = new CepDAOImpl();
		this.cepDAO.setEm(em);
	}
	
	public Cep getCep(String cep) {
		try {
			return cepDAO.findSingleEntity(cep).get();
		} catch (Exception e) {
			System.out.println("CEP não encontrado");
			return null;
		}
        
	}
}
