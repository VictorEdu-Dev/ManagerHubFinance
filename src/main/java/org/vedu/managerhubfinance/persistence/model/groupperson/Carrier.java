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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "carrier")
@Entity
public class Carrier extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "register_date", nullable = false)
	private LocalDateTime registerDate;
	
	@Basic
	@Column(name = "observation", nullable = true, length = 100)
	private String observation;
}
