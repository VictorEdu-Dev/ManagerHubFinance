package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.model.groupbasic.City;
import org.vedu.managerhubfinance.persistence.model.groupbasic.State;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "person")
@Builder
@Table(name = "person_address")
@Entity
public class PersonAddress extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy = "personAddress", fetch = FetchType.LAZY)
	private List<Person> person;
	
	@Basic
	@Column(name = "public_place", nullable = false, length = 150)
	private String publicPlace;
	
	@Basic
	@Column(name = "number", length = 10)
	private String number;
	
	@Basic
	@Column(name = "complement", length = 50)
	private String complement;
	
	@Basic
	@Column(name = "neighborhood", length = 100)
	private String neighborhood;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_ibge_code")
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_ibge_code")
	private State state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "number_cep_cep", nullable = false)
	private Cep numberCep;
	
	@Basic
	@Column(name = "principal", nullable = false, length = 1)
	private String principal;
	
	@Basic
	@Column(name = "delivery", nullable = false, length = 1)
	private String delivery;
	
	@Basic
	@Column(name = "billing", nullable = false, length = 1)
	private String billing;
	
	@Basic
	@Column(name = "correspondence", nullable = false, length = 1)
	private String correspondence;
}
