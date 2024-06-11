package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

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
@ToString(exclude = { "checkbook" })
@Table(name = "fin_verify")
@Entity
public class FinVerify extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "checkbook_id", nullable = false, unique = true)
	private FinCheckbook checkbook;
	
	@Basic
	@Column(name = "number", nullable = true)
	private Integer number;
	
	@Basic
	@Column(name = "status_check", nullable = true, length = 1)
	private String statusCheck;
	
	@Basic
	@Column(name = "status_date", nullable = true)
	private LocalDateTime statusDate;
}
