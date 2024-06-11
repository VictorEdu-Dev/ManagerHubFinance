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
import jakarta.persistence.OneToOne;
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
@ToString(exclude = "bank")
@Builder
@Table(name = "bank_branch")
@Entity
public class BankBranch extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id", nullable = false, referencedColumnName = "id")
	private Bank bank;
	
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
	@Column(name = "address", nullable = false, length = 20)
	private String phone;
	
	@Basic
	@Column(name = "contact", nullable = false, length = 50)
	private String contact;
	
	@Basic
	@Column(name = "observation", nullable = false, length = 100)
	private String observation;
	
	@Basic
	@Column(name = "general_manager", nullable = false, length = 100)
	private String generalManager;
}
