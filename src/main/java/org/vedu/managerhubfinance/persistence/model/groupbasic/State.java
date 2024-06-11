package org.vedu.managerhubfinance.persistence.model.groupbasic;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"cities"})
@Builder
@Table(name = "state")
@Entity
public class State extends PropertiesEntity {
	@Id
	@Column(name = "ibge_code", nullable = false, unique = true)
	private Integer ibgeCode;
	
	@Basic
	@Column(name = "acronym", length = 2, nullable = false, unique = true)
	private String acronym;
	
	@Basic
	@Column(name = "name", length = 50, nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<City> cities;
}
