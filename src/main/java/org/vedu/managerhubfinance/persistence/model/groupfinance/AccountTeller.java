package org.vedu.managerhubfinance.persistence.model.groupfinance;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"bankBranch"})
@Builder
@Table(name = "account_teller")
@Entity
public class AccountTeller extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_branch_id", referencedColumnName = "id")
	private BankBranch bankBranch;
	
	@Basic
	@Column(name = "number", nullable = false, length = 20)
	private String number;
	
	@Basic
	@Column(name = "digit", nullable = false, length = 1)
	private String digit;
	
	@Basic
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Basic
	@Column(name = "type", nullable = false, length = 1)
	private String type;
	
	@Basic
	@Column(name = "description", nullable = false, length = 100)
	private String description;
}
