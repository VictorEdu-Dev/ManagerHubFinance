package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@ToString(exclude = "person")
@Builder
@Table(name = "customer")
@Entity
public class Customer extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@Basic
	@Column(name = "since", nullable = false)
	private LocalDateTime since;
	
	@Basic
	@Column(name = "registration_date", nullable = false)
	private LocalDateTime registrationDate;
	
	@Basic
	@Column(name = "limit_credit", nullable = false)
	private BigDecimal limitCredit;
	
	@Basic
	@Column(name = "discount_rate", nullable = false)
	private BigDecimal discountRate;
	
	@Basic
	@Column(name = "observation", nullable = true, length = 100)
	private String observation;

}
