package org.vedu.managerhubfinance.persistence.repository.person.impl;

import org.vedu.managerhubfinance.persistence.model.groupfinance.AccountTeller;
import org.vedu.managerhubfinance.persistence.repository.CrudRepositoryImpl;
import org.vedu.managerhubfinance.persistence.repository.person.AccountTellerDAO;

import jakarta.ejb.Stateless;

@Stateless
public class AccountTellerDAOImpl extends CrudRepositoryImpl<Long, AccountTeller> implements AccountTellerDAO {

	protected AccountTellerDAOImpl() {
		super(AccountTeller.class);
	}

}
