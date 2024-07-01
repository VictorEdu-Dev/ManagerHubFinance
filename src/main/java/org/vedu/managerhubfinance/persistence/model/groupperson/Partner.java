package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.math.BigDecimal;
import java.util.Map;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.financialblock.CategoryFinance;

import jakarta.persistence.Basic;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"person", "categoryFinance", "registrationDetails", "additionalData"}, callSuper = true)
@Builder
@Table(name = "partner")
@Entity
public class Partner extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "person_type", nullable = false)
	private PersonType personType;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "customer_registration_details", joinColumns = @JoinColumn(name = "customer_id"))
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "person_type", length = 50, nullable = false)
	@Column(name = "registration_details", nullable = false)
	private Map<PersonType, RegistrationDetails> registrationDetails;
	
	@Basic
	@Column(name = "limit_credit", precision = 10, scale = 2)
	private BigDecimal limitCredit;
	
	@Basic
	@Column(name = "payment_condition", length = 50)
	private String paymentCondition;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "customer_additional_data", joinColumns = @JoinColumn(name = "customer_id"))
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "person_type", length = 50, nullable = false)
	@Column(name = "additional_data", nullable = false)
	private Map<PersonType, AdditionalData> additionalData;
	
	@OneToOne(fetch = FetchType.LAZY)
	private CategoryFinance categoryFinance;
	
	@Basic
	@Column(name = "is_billing")
	private Boolean isBilling;
	
	@Basic(fetch = FetchType.LAZY) @Lob
	@Column(name = "observation", length = 200)
	private String observation;
}
