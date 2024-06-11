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
import jakarta.persistence.Lob;
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
@Table(name = "fin_nature_fin")
@Entity
public class FinNatureFin extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "nature_fin", nullable = false, length = 4)
	private FinNatureFinEnum natureFin;
	
	@Lob
	@Column(name = "description", nullable = true, length = 100)
	private String description;
	
	@Lob
	@Column(name = "observation", nullable = true, length = 100)
	private String observation;
	
	@Basic
	@Column(name = "type", nullable = true, length = 1)
	private String type;
	
	@Lob
	@Column(name = "aplicability", nullable = true, length = 100)
	private String aplicability;
}
