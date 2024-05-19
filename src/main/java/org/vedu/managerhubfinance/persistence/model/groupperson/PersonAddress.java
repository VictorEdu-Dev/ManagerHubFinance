package org.vedu.managerhubfinance.persistence.model.persongroup;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Entity;
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
@Table(name = "person_address")
@Entity
public class PersonAddress extends PropertiesEntity {
	private Integer id;
	private List<Person> person;
	private String publicPlace;
	private String number;
	private String complement;
	private String neighborhood;
	private String city;
	private String state;
	private String zipCode;
	private Integer city_ibge;
	private String principal;
	private String delivery;
	private String billing;
	private String correspondence;
	

}
