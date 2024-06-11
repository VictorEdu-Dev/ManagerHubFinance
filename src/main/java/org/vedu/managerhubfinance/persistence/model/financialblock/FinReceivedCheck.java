package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupperson.Person;

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
@ToString(exclude = { "person" })
@Table(name = "fin_received_check")
@Entity
public class FinReceivedCheck extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = true)
	private Person person;
	
	@Basic
	@Column(name = "cpf", nullable = true, length = 11)
	private String cpf;
	
	@Basic
	@Column(name = "cnpj", nullable = true, length = 14)
	private String cnpj;
	
	@Basic
	@Column(name = "name", nullable = true, length = 100)
	private String name;
	
	@Basic
	@Column(name = "bank_code", nullable = true, length = 10)
	private String bankCode;
	
	@Basic
	@Column(name = "agency_code", nullable = true, length = 10)
	private String agencyCode;
	
	@Basic
	@Column(name = "account", nullable = true, length = 20)
	private String account;
	
	@Basic
	@Column(name = "number", nullable = true)
	private Integer number;
	
	@Basic
	@Column(name = "issue_date", nullable = true)
	private LocalDateTime issueDate;
	
	@Basic
	@Column(name = "compensation_date", nullable = true)
	private LocalDateTime compensationDate;
	
	@Basic
	@Column(name = "value", nullable = true, precision = 10, scale = 2)
	private BigDecimal value;
	
	@Basic
	@Column(name = "custody_date", nullable = true)
	private LocalDateTime custodyDate;
	
	@Basic
	@Column(name = "custody_tax", nullable = true, precision = 10, scale = 2)
	private BigDecimal custodyTax;
	
	@Basic
	@Column(name = "custody_commission", nullable = true, precision = 10, scale = 2)
	private BigDecimal custodyCommission;
	
	@Basic
	@Column(name = "descount_date", nullable = true)
	private LocalDateTime descountDate;
	
	@Basic
	@Column(name = "descount_tax", nullable = true, precision = 10, scale = 2)
	private BigDecimal descountTax;
	
	@Basic
	@Column(name = "descount_commission", nullable = true, precision = 10, scale = 2)
	private BigDecimal descountCommission;
	
	@Basic
	@Column(name = "received_value", nullable = true, precision = 10, scale = 2)
	private BigDecimal receivedValue;
}
