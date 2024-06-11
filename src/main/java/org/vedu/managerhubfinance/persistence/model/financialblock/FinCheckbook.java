package org.vedu.managerhubfinance.persistence.model.financialblock;

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
@Table(name = "fin_checkbook")
@Entity
public class FinCheckbook extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "account_teller_id", nullable = false)
	private AccountTeller accountTeller;
	
	@Basic
	@Column(name = "checkbook", nullable = false, length = 10)
	private String checkbook;
	
	@Basic
	@Column(name = "number", nullable = false)
	private Integer number;
	
	@Basic
	@Column(name = "status_check", nullable = false, length = 1)
	private String statusCheck;
}
