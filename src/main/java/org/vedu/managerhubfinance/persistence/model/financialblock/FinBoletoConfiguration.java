package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.math.BigDecimal;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupfinance.AccountTeller;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "accountTeller")
@Table(name = "fin_boleto_configuration")
@Entity
public class FinBoletoConfiguration extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "account_teller_id", nullable = false)
	private AccountTeller accountTeller;
	
	@Basic
	@Column(name = "instruction_0001", nullable = true, length = 100)
	private String instruction0001;
	
	@Basic
	@Column(name = "instruction_0002", nullable = true, length = 100)
	private String instruction0002;
	
	@Basic
	@Column(name = "instruction_0003", nullable = true, length = 250)
	private String filePathRemittance;
	
	@Basic
	@Column(name = "file_path_return", nullable = true, length = 250)
	private String filePathReturn;
	
	@Basic
	@Column(name = "file_path_print", nullable = true, length = 250)
	private String filePathPrint;
	
	@Basic
	@Column(name = "file_path_pdf", nullable = true, length = 250)
	private String filePathPdf;
	
	@Basic
	@Column(name = "message", nullable = true, length = 250)
	private String message;
	
	@Basic
	@Column(name = "payment_place", nullable = true, length = 250)
	private String paymentPlace;
	
	@Basic
	@Column(name = "remittance_layout", nullable = true, length = 3)
	private String remittanceLayout;
	
	@Basic
	@Column(name = "accept", nullable = true)
	private Boolean accept;
	
	@Basic
	@Column(name = "cash", nullable = true)
	private Boolean cash;
	
	@Basic
	@Column(name = "wallet", nullable = true)
	private String wallet;
	
	@Basic
	@Column(name = "agreement_code", nullable = true, length = 20)
	private String agreementCode;
	
	@Basic
	@Column(name = "cedent_code", nullable = true, length = 20)
	private String cedentCode;
	
	@Basic
	@Column(name = "tax_fine", nullable = true, precision = 20, scale = 2)
	private BigDecimal taxFine;
	
	@Basic
	@Column(name = "tax_interest", nullable = true, precision = 20, scale = 2)
	private BigDecimal taxInterest;
	
	@Basic
	@Column(name = "days_protest", nullable = true)
	private Integer daysProtest;
	
	@Basic
	@Column(name = "previous_number", nullable = true, length = 50)
	private String previousNumber;

}
