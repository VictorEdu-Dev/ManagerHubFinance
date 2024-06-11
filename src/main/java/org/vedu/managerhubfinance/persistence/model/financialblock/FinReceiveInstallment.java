package org.vedu.managerhubfinance.persistence.model.financialblock;

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
import jakarta.persistence.Lob;
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
		"finInstallmentStatus",
		"finPaymentType", 
		"finReceiveLaunch", 
		"finReceivedCheck" })
@Table(name = "fin_receive_installment")
@Entity
public class FinReceiveInstallment extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "installment_status_id", nullable = false, unique = true)
	private FinInstallmentStatus finInstallmentStatus;
	
	@ManyToOne
	@JoinColumn(name = "payment_type_id", nullable = true)
	private FinPaymentType finPaymentType;
	
	@ManyToOne
	@JoinColumn(name = "receive_launch_id", nullable = false, unique = true)
	private FinReceiveLaunch finReceiveLaunch;
	
	@ManyToOne
	@JoinColumn(name = "received_check_id", nullable = true)
	private FinReceivedCheck finReceivedCheck;
	
	@Basic
	@Column(name = "installment_number", nullable = true)
	private Integer installmentNumber;
	
	@Basic
	@Column(name = "issuing_date", nullable = true)
	private LocalDateTime issuingDate;
	
	@Basic
	@Column(name = "due_date", nullable = true)
	private LocalDateTime dueDate;
	
	@Basic
	@Column(name = "receipt_date", nullable = true)
	private LocalDateTime receiptDate;
	
	@Basic
	@Column(name = "descount_date", nullable = true)
	private LocalDateTime descountDate;
	
	@Basic
	@Column(name = "value", nullable = true, precision = 10, scale = 2)
	private BigDecimal value;
	
	@Basic
	@Column(name = "interest", nullable = true, precision = 10, scale = 2)
	private BigDecimal interest;
	
	@Basic
	@Column(name = "fine", nullable = true, precision = 10, scale = 2)
	private BigDecimal fine;
	
	@Basic
	@Column(name = "discount", nullable = true, precision = 10, scale = 2)
	private BigDecimal discount;
	
	@Basic
	@Column(name = "issuedBoleto", nullable = true)
	private Boolean issuedBoleto;
	
	@Basic
	@Column(name = "boleto_number", nullable = true, length = 50)
	private String boletoNumber;
	
	@Basic
	@Column(name = "received_value", nullable = true, precision = 10, scale = 2)
	private BigDecimal receivedValue;
	
	@Lob
	@Column(name = "historical", nullable = true, length = 200)
	private String historical;

}
