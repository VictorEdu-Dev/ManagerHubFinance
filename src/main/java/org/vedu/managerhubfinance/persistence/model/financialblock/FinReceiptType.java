package org.vedu.managerhubfinance.persistence.model.financialblock;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "fin_receipt_type")
@Entity
public class FinReceiptType extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "receipt_type", nullable = false, length = 2)
	private FinReceiptTypeEnum receiptType;
	
	@Lob
	@Column(name = "description", nullable = true, length = 100)
	private String description;
}
