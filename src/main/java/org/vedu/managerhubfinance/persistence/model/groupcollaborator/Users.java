package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import java.util.Map;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;
import org.vedu.managerhubfinance.persistence.model.Situation;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapKeyJoinColumn;
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
@ToString(exclude = { "roles", "collaborator", "functions"})
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
	
	@ElementCollection
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @MapKeyJoinColumn(name = "roles_id")
    @Column(name = "enabled")
    private Map<Roles, Boolean> roles;

	@ElementCollection
    @JoinTable(
        name = "user_functions",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @MapKeyJoinColumn(name = "functions_id")
    @Column(name = "enabled")
    private Map<Function, Boolean> functions;
	
	@Basic
	@Column(name = "username", nullable = false, unique = true, length = 100)
	private String username;
	
	@Basic
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	@Basic
	@Column(name = "email", nullable = false)
	private String email;
	
	@Basic
	@Column(name = "situation")
	private Situation situation;
}
