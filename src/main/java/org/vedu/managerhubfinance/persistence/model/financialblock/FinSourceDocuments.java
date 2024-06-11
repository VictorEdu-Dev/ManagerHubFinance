package org.vedu.managerhubfinance.persistence.model.financialblock;

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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "fin_source_documents")
@Entity
public class FinSourceDocuments extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(name = "code", nullable = true, length = 3)
	private String code;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "acronym", nullable = true, length = 10)
	private FinNatureFinEnum acronym;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "description", nullable = true, length = 100)
	private FinNatureFinEnum description;

}
