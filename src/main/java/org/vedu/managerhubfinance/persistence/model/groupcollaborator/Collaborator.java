package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.groupperson.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "person", "jobTitle", "departament"})
@Builder
@Table(name = "collaborator")
@Entity
public class Collaborator extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@OneToOne
	@JoinColumn(name = "job_title_id", nullable = false)
	private JobTitle jobTitle;
	
	@OneToOne
	@JoinColumn(name = "departament_id", nullable = false)
	private Departament departament;
	
	@Basic
	@Column(name = "enrollment", nullable = false, unique = true, length = 100)
	private String enrollment;
	
	@Basic
	@Column(name = "registration_date", nullable = false)
	private LocalDateTime registrationDate;
	
	@Basic
	@Column(name = "admission_date", nullable = false)
	private LocalDateTime admissionDate;
	
	@Basic
	@Column(name = "resignation_date")
	private LocalDateTime resignationDate;
	
	@Basic
	@Column(name = "ctps_number", length = 100)
	private String ctpsNumber;
	
	@Basic
	@Column(name = "ctps_serie", length = 100)
	private String ctpsSerie;
	
	@Basic
	@Column(name = "ctps_state", length = 100)
	private String ctpsState;
	
	@Basic
	@Column(name = "ctps_issue_date")
	private LocalDateTime ctpsIssueDate;
	
	@Lob
	@Column(name = "ctps_issue_agency", length = 100)
	private String observation;

}
