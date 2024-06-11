package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupfinance.AccountTeller;
import org.vedu.managerhubfinance.persistence.model.groupperson.Supplier;

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
		"accountTeller",
		"supplier",
		"sourceDocuments",
		"natureFin" })
@Table(name = "fin_payment_launch")
@Entity 
public class FinPaymentLaunch extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "source_documents_id", nullable = false, unique = true)
	private FinSourceDocuments sourceDocuments;
	
	@ManyToOne
	@JoinColumn(name = "nature_fin_id", nullable = false, unique = true)
	private FinNatureFin natureFin;
	
	@ManyToOne
	@JoinColumn(name = "account_teller_id", nullable = false)
	private AccountTeller accountTeller;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;
	
	@Basic
	@Column(name = "installment_quantity", nullable = true)
	private Integer installmentQuantity;
	
	@Basic
	@Column(name = "payment_value", nullable = true, precision = 12, scale = 2)
	private BigDecimal paymentValue;
	
	@Basic
	@Column(name = "launch_date", nullable = true)
	private LocalDateTime launchDate;
	
	@Basic
	@Column(name = "document_number", nullable = true)
	private String documentNumber;
	
	@Basic
	@Column(name = "first_expiration_date", nullable = true)
	private LocalDateTime firstExpirationDate;
	
	@Basic
	@Column(name = "commission_tax", nullable = true)
	private String imageDocument;
	
	@Basic
	@Column(name = "commission_value", nullable = true)
	private Integer installmentInterval;
	
	@Basic
	@Column(name = "installment_interval", nullable = true)
	private String fixedDay;
}
