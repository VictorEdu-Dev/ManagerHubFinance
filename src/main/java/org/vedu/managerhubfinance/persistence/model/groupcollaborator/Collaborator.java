package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupperson.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "person", "jobTitle", "departament"})
@Table(name = "collaborator")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "COLLABORATOR_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Collaborator extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	@Column(name = "photo")
	private byte[] photo;
	
	@OneToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@OneToOne
	@JoinColumn(name = "job_title_id", nullable = false)
	private JobTitle jobTitle;
	
	@OneToOne
	@JoinColumn(name = "departament_id", nullable = false)
	private Departament departament;
	
	@Column(name = "admission_date", nullable = false)
	private LocalDateTime admissionDate;
	
	@Basic
	@Column(name = "pis_pasep", length = 11)
	private String pisPasep;
	
	@Basic
	@Column(name = "ctps", length = 15)
	private String ctps;
}
