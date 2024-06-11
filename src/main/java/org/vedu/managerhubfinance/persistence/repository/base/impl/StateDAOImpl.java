package org.vedu.managerhubfinance.persistence.repository.base.impl;

import org.vedu.managerhubfinance.persistence.model.groupbasic.State;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.base.StateDAO;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.TypedQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class StateDAOImpl extends CrudRepositoryImpl<String, State> implements StateDAO<String, State> {
	
	public StateDAOImpl(EntityManager entityManager) {
		super(State.class);
	}

	@Override
	public State findByName(String name) {
		TypedQuery<State> query = 
				getEm()
				.createQuery(
						"SELECT s FROM State s WHERE s.name = :name",
						State.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}

	@Override
	public State findByName(String name, LockModeType lockModeType) {
		TypedQuery<State> query =
				getEm()
				.createQuery(
						"SELECT s FROM State s WHERE s.name = :name",
						State.class);
		query.setParameter("name", name);
		query.setLockMode(lockModeType);
		return query.getSingleResult();
	}
}
