package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "corporate_entity")
@Entity
public class CorporateEntity extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@Basic
	@Column(name = "cnpj", nullable = false, length = 20)
	private String cnpj;
	
	@Basic
	@Column(name = "fantasy_name", nullable = false, length = 150)
	private String fantasyName;
	
	@Basic
	@Column(name = "state_registration", nullable = false, length = 20)
	private String stateRegistration;
	
	@Basic
	@Column(name = "municipal_registration", nullable = false, length = 20)
	private String municipalRegistration;
	
	@Basic
	@Column(name = "date_of_constitution", nullable = false)
	private LocalDateTime dateOfConstitution;
	
	@Basic
	@Column(name = "type_of_company", nullable = false, length = 1)
	private String typeOfCompany;
	
	@Basic
	@Column(name = "crt", nullable = false, length = 20)
	private String crt;
}
