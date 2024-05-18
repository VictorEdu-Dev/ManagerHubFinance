package org.vedu.managerhubfinance.persistence.model;

import org.vedu.managerhubfinance.persistence.model.listeners.PersonAccountListener;
import org.vedu.managerhubfinance.persistence.model.persongroup.Person;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(PersonAccountListener.class)
@Table(name = "person_account")
@Entity
public class PersonAccount extends PropertiesEntity {
	@EmbeddedId
	private PersonAccountId id;
	
	@OneToOne
	@JoinColumn(name = "person_id", nullable = false, unique = true)
	private Person person;
	
	@Basic
	@Column(name = "role", nullable = false, length = 1)
	private String role;
	
	@Basic
	@Column(name = "status", nullable = false, length = 1)
	private String status;	
	
	@Basic
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	public String toString() {
		return "PersonAccount [id=" + id + ", person=" + person.getName() 
				+ ", role=" + role + ", status=" + status
				+ ", password=" + password + "]";
	}

}
