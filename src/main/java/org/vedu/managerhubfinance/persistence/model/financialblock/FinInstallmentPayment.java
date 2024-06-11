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
		"paymentLaunch",
		"installment",
		"paymentType",
		"issuedCheck" })
@Table(name = "fin_installment_payment")
@Entity
public class FinInstallmentPayment extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "payment_launch_id", nullable = false, unique = true)
	private FinPaymentLaunch paymentLaunch;
	
	@ManyToOne
	@JoinColumn(name = "installment_id", nullable = false, unique = true)
	private FinInstallmentStatus installment;
	
	@ManyToOne
	@JoinColumn(name = "payment_type_id", nullable = true, unique = true)
	private FinPaymentType paymentType;
	
	@ManyToOne
	@JoinColumn(name = "issued_check_id", nullable = true, unique = true)
	private FinIssuedCheck issuedCheck;
	
	@Basic
	@Column(name = "number_installment", nullable = true)
	private Integer numberInstallment;
	
	@Basic
	@Column(name = "issue_date", nullable = true)
	private LocalDateTime issueDate;
	
	@Basic
	@Column(name = "due_date", nullable = true)
	private LocalDateTime dueDate;
	
	@Basic
	@Column(name = "payment_date", nullable = true)
	private LocalDateTime paymentDate;
	
	@Basic
	@Column(name = "discount_date", nullable = true)
	private LocalDateTime discountDate;
	
	@Basic
	@Column(name = "value", nullable = true)
	private BigDecimal value;
	
	@Basic
	@Column(name = "interest", nullable = true)
	private BigDecimal interest;
	
	@Basic
	@Column(name = "fine", nullable = true)
	private BigDecimal fine;
	
	@Basic
	@Column(name = "discount", nullable = true)
	private BigDecimal discount;
	
	@Basic
	@Column(name = "paid_value", nullable = true)
	private BigDecimal paidValue;
	
	@Lob
	@Column(name = "historical", nullable = true, length = 200)
	private String historical;
}
