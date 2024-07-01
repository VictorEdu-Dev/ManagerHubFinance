package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.time.LocalDateTime;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public final class RegistrationDetailsPF extends RegistrationDetails {
	@Basic
	@Column(name = "since", nullable = false)
	private LocalDateTime since;
	
	@Basic
	@Column(name = "cpf", length = 20)
	private String cpf;
	
	@Basic
	@Column(name = "rg", length = 20)
	private String rg;
	
	@Basic
	@Column(name = "issuing_agency", length = 50)
	private String issuingAgency;
}
