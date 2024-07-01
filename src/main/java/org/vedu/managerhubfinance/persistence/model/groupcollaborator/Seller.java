package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import java.math.BigDecimal;
import java.util.Map;

import jakarta.persistence.Basic;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"collaborator", "users"})
@Builder
@Entity
@DiscriminatorValue("SELLER")
public class Seller extends Collaborator {
	@OneToOne
	@JoinColumn(name = "collaborator_id", nullable = false)
	private Collaborator collaborator;
	
	@Column(name = "commissioning")
	@Enumerated(EnumType.STRING)
	private Commissioning commissioning;
	
	@Column(name = "commission_type")
	@Enumerated(EnumType.STRING)
	private CommissionType commissioningType;
	
	@ElementCollection
	@CollectionTable(name = "commission_values", joinColumns = @JoinColumn(name = "seller_id"))
	@MapKeyColumn(name = "commission_key")
	@Column(name = "commission_value", nullable = true, precision = 3, scale = 2)
	private Map<BigDecimal, BigDecimal> commissionValues;
	
	@Basic
	@Column(name = "commission", precision = 3, scale = 2, nullable = true)
	private BigDecimal commission;
	
	@Basic
	@Column(name = "discount_limit")
	private BigDecimal discountLimit;
	
	@Basic
	@Column(name = "number_of_installments_contract")
	private Integer numberOfInstallmentsContract;
	
	@Basic
	@OneToOne
	@JoinColumn(name = "users_id", unique = true)
	private Users users;
}
