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
import jakarta.persistence.Lob;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "person")
@Builder
@Table(name = "person_contact")
@Entity
public class PersonContact extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@Basic @Lob
	@Column(name = "contact_information", length = 200)
	private String contactInformation;
	
	@Basic
	@Column(name = "email", length = 150)
	private String email;
	
	@Basic
	@Column(name = "email_nfe", length = 20)
	private String emailNfe;
	
	@Basic
	@Column(name = "phone", length = 20)
	private String phone;
	
	@Basic
	@Column(name = "cell_phone", length = 20)
	private String cellPhone;
	
	@Basic
	@Column(name = "operator", length = 20)
	private String operator;
	
	@Basic
	@Column(name = "fax", length = 100)
	private String fax;
	
	@Basic
	@Column(name = "website", length = 100)
	private String website;
	
	@Basic
	@Column(name = "skype", length = 100)
	private String skype;
	
	@Basic
	@Column(name = "next_visit")
	private LocalDateTime nextVisit;
}
