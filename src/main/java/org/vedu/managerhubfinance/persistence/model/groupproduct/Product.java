package org.vedu.managerhubfinance.persistence.model.groupproduct;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
@Entity
public class Product extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_category_id", nullable = true)
	private ProductCategory productCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_subcategory_id", nullable = true)
	private ProductSubcategory productSubcategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_brand_id", nullable = true)
	private ProductBrand productBrand;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_batch_id", nullable = true)
	private ProductBatch productBatch;
	
	@Basic
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Lob
	@Column(name = "description", nullable = true, length = 100)
	private String description;
	
	@Basic
	@Column(name = "gtin", nullable = true, length = 14)
	private String gtin;
	
	@Basic
	@Column(name = "ncm", nullable = true, length = 8)
	private String ncm;
	
	@Basic
	@Column(name = "internal_code", nullable = true, length = 50)
	private String internalCode;
	
	@Basic
	@Column(name = "value_buy", nullable = true, precision = 15, scale = 2)
	private BigDecimal valueBuy;
	
	@Basic
	@Column(name = "value_sale", nullable = true, precision = 15, scale = 10)
	private BigDecimal valueSale;
	
	@Basic
	@Column(name = "value_promotion", nullable = true, precision = 15, scale = 2)
	private BigDecimal maxBatch;
	
	@Basic
	@Column(name = "min_batch", nullable = true, precision = 15, scale = 2)
	private BigDecimal minBatch;
	
	@Basic
	@Column(name = "quantity_batch", nullable = true, precision = 15, scale = 2)
	private BigDecimal quantityBatch;
	
	@Basic
	@Column(name = "registration_date", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime registrationDate;
	
	@Basic
	@Column(name = "expiration_date", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime expirationDate;
	
	@Basic
	@Column(name = "manufacture_date", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime manufactureDate;
}
