package org.vedu.managerhubfinance.persistence.model.groupperson;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public abstract sealed class RegistrationDetails permits RegistrationDetailsPF, RegistrationDetailsPJ {
	@Basic
	@Column(name = "state_registration", length = 50)
	private String stateRegistration;
}
