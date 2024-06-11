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
@Table(name = "fin_bank_cash_closing")
@Entity
public class FinBankCashClosing extends PropertiesEntity {
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
	@Column(name = "previous_balance", nullable = true, precision = 10, scale = 2)
	private BigDecimal previousBalance;
	
	@Basic
	@Column(name = "received", nullable = true, precision = 10, scale = 2)
	private BigDecimal received;
	
	@Basic
	@Column(name = "paid", nullable = true, precision = 10, scale = 2)
	private BigDecimal paid;
	
	@Basic
	@Column(name = "final_balance", nullable = true, precision = 10, scale = 2)
	private BigDecimal finalBalance;
	
	@Basic
	@Column(name = "check_not_compensated", nullable = true, precision = 10, scale = 2)
	private BigDecimal checkNotCompensated;
	
	@Basic
	@Column(name = "unable_balance", nullable = true, precision = 10, scale = 2)
	private BigDecimal unableBalance;
}
