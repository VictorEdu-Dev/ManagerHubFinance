package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.util.List;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@ToString(exclude = "personNatural")
@Builder
@Table(name = "marital_status")
@Entity
public class MaritalStatus extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "maritalStatus", fetch = FetchType.LAZY)
	private List<PersonNatural> personNatural;
	
	@Basic
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Basic
	@Column(name = "description", nullable = false, length = 100)
	private String description;
}
