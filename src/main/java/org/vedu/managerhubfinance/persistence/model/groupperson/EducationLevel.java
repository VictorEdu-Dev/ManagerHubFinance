package org.vedu.managerhubfinance.persistence.model.groupperson;

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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "education_level")
@Entity
public class EducationLevel extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Basic
	@Column(name = "description", nullable = false, length = 100)
	private String description;
}
