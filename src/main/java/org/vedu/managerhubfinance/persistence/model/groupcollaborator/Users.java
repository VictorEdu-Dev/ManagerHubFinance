package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "roles", "collaborator"})
@Builder
@Table(name = "users")
@Entity
public class Users extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "collaborator_id", nullable = false)
	private Collaborator collaborator;
	
	@OneToOne
	@JoinColumn(name = "roles_id", nullable = false)
	private Roles roles;
	
	@Basic
	@Column(name = "username", nullable = false, unique = true, length = 100)
	private String username;
	
	@Basic
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	@Basic
	@Column(name = "admin", nullable = false, length = 1)
	private String admin;
	
	@Basic
	@Column(name = "active", nullable = false)
	private LocalDateTime registrationDate;
}
