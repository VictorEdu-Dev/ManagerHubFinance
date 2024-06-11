package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
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
@ToString(exclude = {"functions"})
@Builder
@Table(name = "roles")
@Entity
public class Roles extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Lob
	@Column(name = "description", nullable = true, length = 100)
	private String description;
	
	@ManyToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JoinTable(
			name = "roles_function", 
			joinColumns = @JoinColumn(name = "roles_id"),
			inverseJoinColumns = @JoinColumn(name = "function_id"))
	private List<Function> functions;
}
