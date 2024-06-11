package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "person_natural")
@Entity
public class PersonNatural extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "education_level_id")
	private EducationLevel educationLevel;
	
	@OneToOne
	@JoinColumn(name = "marital_status_id")
	private MaritalStatus maritalStatus;
	
	@Basic
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Basic
	@Column(name = "rg", nullable = false, length = 20)
	private String generalResgiter;
	
	@Basic
	@Column(name = "orgao_emissor", nullable = false, length = 20)
	private String issuingAuthority;
	
	@Basic
	@Column(name = "data_emissao", nullable = false)
	private LocalDateTime issuingDate;
	
	@Basic
	@Column(name = "data_nascimento", nullable = false)
	private LocalDateTime dateOfBirth;
	
	@Basic
	@Column(name = "sexo", nullable = false, length = 1)
	private String sex;
	
	@Basic
	@Column(name = "raca", nullable = false, length = 1)
	private String race;
	
	@Basic
	@Column(name = "nacionalidade", nullable = false, length = 100)
	private String nationality;
	
	@Basic
	@Column(name = "naturalidade", nullable = false, length = 100)
	private String placeOfBirth;
	
	@Basic
	@Column(name = "nome_pai", nullable = false, length = 100)
	private String fatherName;
	
	@Basic
	@Column(name = "nome_mae", nullable = false, length = 100)
	private String motherName;

}
