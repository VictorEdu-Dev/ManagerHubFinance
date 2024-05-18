package org.vedu.managerhubfinance.persistence.model.persongroup;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "identity_card")
@Entity
public class MaritalStatus extends PropertiesEntity{
	private Long id;
	private String name;
	private String description;
}
