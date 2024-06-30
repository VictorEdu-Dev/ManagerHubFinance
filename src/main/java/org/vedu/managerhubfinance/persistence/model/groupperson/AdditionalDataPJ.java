package org.vedu.managerhubfinance.persistence.model.groupperson;

import org.vedu.managerhubfinance.persistence.model.Situation;
import org.vedu.managerhubfinance.persistence.model.groupcollaborator.Seller;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public final class AdditionalDataPJ extends AdditionalData {
	
	@Basic
	@Enumerated(EnumType.STRING)
	@Column(name = "contact_type", length = 20)
	private ContactType contactType;
	
	@Basic
	@Enumerated(EnumType.STRING)
	@Column(name = "situation", length = 20)
	private Situation situation;
	
	@Basic
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private Seller seller;

	@Basic
	@Column(name = "suframa_registration", length = 50)
	private String suframaRegistration;
}
