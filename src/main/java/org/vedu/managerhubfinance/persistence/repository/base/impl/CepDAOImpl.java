package org.vedu.managerhubfinance.persistence.repository.base.impl;

import java.util.List;
import java.util.Optional;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.base.CepDAO;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CepDAOImpl extends CrudRepositoryImpl<String, Cep> implements CepDAO<String, Cep> {
	
	public CepDAOImpl() {
		super(Cep.class);
	}

	@Override
	public List<Cep> findAll(boolean withCity) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Cep> cq = cb.createQuery(Cep.class);
		Root<Cep> root = cq.from(Cep.class);
		cq.select(root);
		if (withCity)
			root.fetch("city");
		return getEm().createQuery(cq).getResultList();
	}

	@Override
	public List<Cep> findByName(String name, boolean subtring) {
		CriteriaBuilder cb = getEm().getCriteriaBuilder();
		CriteriaQuery<Cep> cq = cb.createQuery(Cep.class);
		Root<Cep> root = cq.from(Cep.class);
		cq.select(root);
		if (subtring)
			cq.where(cb.like(root.get("name"), "%" + name + "%"));
		else
			cq.where(cb.equal(root.get("name"), name));
		return getEm().createQuery(cq).getResultList();
	}

	@Override
	public void makeTransientById(String cep) {
		getEm()
		.createQuery("delete from Cep c where c.cep = :cep")
		.setParameter("cep", cep)
		.executeUpdate();
	}

	@Override
	public Optional<Cep> findByStreet(String street) {
		TypedQuery<Cep> q = 
				getEm()
				.createQuery(
						"select c from Cep c where c.street = := street",
						Cep.class);
		Optional<Cep> result = 
				Optional.ofNullable(q
						.setParameter("street", street)
						.getSingleResult());
		return result;
	}
	
	public static CepDAOImpl getInstance() {
		return new CepDAOImpl();
	}
}
