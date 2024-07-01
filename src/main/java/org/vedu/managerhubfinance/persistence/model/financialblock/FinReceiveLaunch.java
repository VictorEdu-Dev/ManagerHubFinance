package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupfinance.AccountTeller;
import org.vedu.managerhubfinance.persistence.model.groupperson.Partner;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = { 
		"finSourceDocuments",
		"finNatureFin",
		"customer",
		"accountTeller"})
@Table(name = "fin_receive_launch")
@Entity
public class FinReceiveLaunch extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "source_document_id", nullable = false, unique = true)
	private FinSourceDocuments finSourceDocuments;
	
	@ManyToOne
	@JoinColumn(name = "nature_fin_id", nullable = false, unique = true)
	private FinNatureFin finNatureFin;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Partner customer;
	
	@ManyToOne
	@JoinColumn(name = "account_teller_id", nullable = false)
	private AccountTeller accountTeller;
	
	@Basic
	@Column(name = "installment_quantity", nullable = true)
	private Integer installmentQuantity;
	
	@Basic
	@Column(name = "receive_value", nullable = true, precision = 10, scale = 2)
	private BigDecimal receiveValue;
	
	@Basic
	@Column(name = "launch_date", nullable = true)
	private LocalDateTime launchDate;
	
	@Basic
	@Column(name = "document_number", nullable = true, length = 50)
	private String documentNumber;
	
	@Basic
	@Column(name = "first_expiration_date", nullable = true)
	private LocalDateTime firstExpirationDate;
	
	@Basic
	@Column(name = "commission_tax", nullable = true, precision = 10, scale = 2)
	private BigDecimal commissionTax;
	
	@Basic
	@Column(name = "commission_value", nullable = true, precision = 10, scale = 2)
	private BigDecimal commissionValue;
	
	@Basic
	@Column(name = "installment_interval", nullable = true)
	private Integer installmentInterval;
	
	@Basic
	@Column(name = "fixed_day", nullable = true, length = 2)
	private String fixedDay;
}
