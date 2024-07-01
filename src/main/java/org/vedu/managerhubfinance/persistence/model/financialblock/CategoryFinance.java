package org.vedu.managerhubfinance.persistence.model.financialblock;

import java.util.Set;

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
import jakarta.persistence.OneToMany;
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
@Entity
@Table(name = "category_finance")
public class CategoryFinance extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Lob @Basic(fetch = FetchType.LAZY)
	@Column(name = "description", nullable = true, length = 1000)
	private String description;
	
	@OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
	private Set<CategoryFinance> subCategories;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_category_id")
	private CategoryFinance parentCategory;
}
