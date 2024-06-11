package org.vedu.managerhubfinance.persistence.model.groupbasic;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"city"})
@Builder
@Table(name = "cep")
@Entity
public class Cep extends PropertiesEntity {
	@Id
	@Column(name = "cep", length = 10, nullable = false, unique = true)
	private String cep;
	
	@Basic
	@Column(name = "name_city", length = 50, nullable = true)
	private String nameCity;
	
	@Basic
	@Column(name = "acronym_state", length = 10, nullable = true)
	private String acronymState;
	
	@Basic
	@Column(name = "street", length = 150, nullable = true)
	private String street;
	
	@Basic
	@Column(name = "neighborhood", length = 150, nullable = true)
	private String neighborhood;
	
	@Basic
	@Column(name = "complement", length = 150, nullable = true)
	private String complement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_ibge_code", nullable = true)
	private City city;
}
