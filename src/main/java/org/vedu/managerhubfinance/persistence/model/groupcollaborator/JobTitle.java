package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import java.math.BigDecimal;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "job_title")
@Entity
public class JobTitle extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(nullable = false, unique = true, length = 50)
	private String name;
	
	@Lob
	@Column(nullable = true, length = 100)
	private String description;
	
	@Basic
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal salary;
	
	@Basic
	@Column(nullable = true, length = 10)
	private String cbo1994;
	
	@Basic
	@Column(nullable = true, length = 10)
	private String cbo2002;
}
