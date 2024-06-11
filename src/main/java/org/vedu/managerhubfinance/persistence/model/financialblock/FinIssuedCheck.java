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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "fin_issued_check")
@Entity
public class FinIssuedCheck extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(name = "issue_date", nullable = true)
	private LocalDateTime issueDate;
	
	@Basic
	@Column(name = "compensation_date", nullable = true)
	private LocalDateTime compensationDate;
	
	@Basic
	@Column(name = "due_date", nullable = true)
	private LocalDateTime dueDate;
	
	@Basic
	@Column(name = "value", nullable = true, precision = 12, scale = 2)
	private BigDecimal value;
	
	@Basic
	@Column(name = "status", nullable = true)
	private String nominal;
}
