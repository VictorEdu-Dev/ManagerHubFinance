package org.vedu.managerhubfinance.persistence.model.persongroup;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Customer extends PropertiesEntity {
	private Long id;
	private Person person;
	private LocalDateTime since;
	private LocalDateTime registrationDate;
	private BigDecimal limitCredit;
	private BigDecimal discountRate;
	private String observation;

}
