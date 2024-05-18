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
@Table(name = "corporate_entity")
@Entity
public class CorporateEntity extends PropertiesEntity {
	private Integer id;
	private Person person;
	private String cnpj;
	private String fantasyName;
	private String stateRegistration;
	private String municipalRegistration;
	private String dateOfConstitution;
	private String typeOfCompany;
	private String crt;
}
