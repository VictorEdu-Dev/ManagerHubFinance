package org.vedu.managerhubfinance.persistence.model.persongroup;

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
@Table(name = "identity_card")
@Entity
public class NaturalPerson extends PropertiesEntity {
	private Integer id;
	private Person person;
	private String educationLevel;
	private String maritalStatus;
	private String cpf;
	private String generalResgiter;
	private String issuingAuthority;
	private String issuingDate;
	private String dateOfBirth;
	private String sex;
	private String race;
	private String nationality;
	private String placeOfBirth;
	private String fatherName;
	private String motherName;

}
