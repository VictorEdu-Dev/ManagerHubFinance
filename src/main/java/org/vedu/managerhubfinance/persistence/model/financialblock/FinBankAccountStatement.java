package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupfinance.AccountTeller;

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
@ToString(exclude = { "accountTeller" })
@Table(name = "fin_bank_account_statement")
@Entity
public class FinBankAccountStatement extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "account_teller_id", nullable = false, unique = true)
	private AccountTeller accountTeller;
	
	@Basic
	@Column(name = "mouth_year", nullable = true, length = 10)
	private String mouthYear;
	
	@Basic
	@Column(name = "mouth", nullable = true, length = 2)
	private String mouth;
	
	@Basic
	@Column(name = "year", nullable = true, length = 4)
	private String year;
	
	@Basic
	@Column(name = "moviment_date", nullable = true)
	private LocalDateTime movimentDate;
	
	@Basic
	@Column(name = "trial_balance_date", nullable = true)
	private LocalDateTime trialBalanceDate;
	
	@Lob
	@Column(name = "historical", nullable = true, length = 500)
	private String historical;
	
	@Basic
	@Column(name = "document", nullable = true, length = 20)
	private String document;
	
	@Basic
	@Column(name = "value", nullable = true, precision = 10, scale = 2)
	private BigDecimal value;
	
	@Basic
	@Column(name = "conciliation", nullable = true, length = 1)
	private String conciliation;
	
	@Lob
	@Column(name = "observation", nullable = true, length = 500)
	private String observation;
}
