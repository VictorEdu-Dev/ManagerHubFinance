package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "roles", "function"})
@Builder
@Table(name = "roles_function")
@Entity
public class RolesFunction extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "roles_id")
	private Roles roles;
	
	@ManyToOne
	@JoinColumn(name = "function_id")
	private Function function;
	
	@Basic
	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@Basic
	@Column(name = "can_create", nullable = false)
	private Boolean canCreate;
	
	@Basic
	@Column(name = "can_read", nullable = false)
	private Boolean canAlter;
	
	@Basic
	@Column(name = "can_update", nullable = false)
	private Boolean canDelete;
}
