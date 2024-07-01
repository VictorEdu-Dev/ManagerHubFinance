package org.vedu.managerhubfinance.persistence.model.groupperson;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public final class RegistrationDetailsPJ extends RegistrationDetails {
	@Basic
	@Column(name = "cnpj", nullable = false, length = 20)
	private String cnpj;
	
	@Basic
	@Column(name = "tax_regime_code", length = 50)
	private String taxRegimeCode;
	
	@Basic
	@Column(name = "municipal_registration", length = 50)
	private String municipalRegistration;
	
	@Basic
	@Column(name = "isExcempt")
	private boolean isExcempt;
	
	@Basic
	@Column(name = "taxpayer", length = 50)
	private String taxpayer;
}
