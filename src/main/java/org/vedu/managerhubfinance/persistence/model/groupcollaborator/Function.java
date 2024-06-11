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
@ToString(exclude = { "roles"})
@Builder
@Table(name = "function")
@Entity
public class Function extends PropertiesEntity {
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
			mappedBy = "functions", 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL)
	private List<Roles> roles;
}
