package org.vedu.managerhubfinance.persistence.model.groupbasic;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "code_situation")
@Entity
public class CodeSituation extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private CodeSituationEnum type;
	
	@Basic
	@Column(name = "code", nullable = false, length = 10)
	private String code;
	
	@Basic
	@Column(name = "description", nullable = false, length = 100)
	private String description;
	
	@Basic
	@Column(name = "obs", nullable = true, length = 100)
	private String obs;
	
	@Basic
	@Column(name = "aplicability", nullable = true, length = 100)
	private String aplicability;
	
	@Basic
	@Column(name = "denomination", nullable = true, length = 100)
	private String denomination;
}
