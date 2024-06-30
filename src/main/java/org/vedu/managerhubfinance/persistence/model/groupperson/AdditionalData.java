package org.vedu.managerhubfinance.persistence.model.groupperson;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public abstract sealed class AdditionalData permits AdditionalDataPF, AdditionalDataPJ {
	@Basic
	@Column(name = "average_load", length = 20)
	private String averageLoad;
}
