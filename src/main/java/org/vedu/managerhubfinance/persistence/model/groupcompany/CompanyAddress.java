package org.vedu.managerhubfinance.persistence.model.groupcompany;

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
@ToString(exclude = {"company"})
@Builder
@Table(name = "company_address")
@Entity
public class CompanyAddress extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	@Basic
	@Column(name = "street", nullable = false, length = 50)
	private String street;
	
	@Basic
	@Column(name = "number", nullable = false, length = 10)
	private String number;
	
	@Basic
	@Column(name = "complement", length = 50)
	private String complement;
	
	@Basic
	@Column(name = "neighborhood", nullable = false, length = 50)
	private String neighborhood;
	
	@Basic
	@Column(name = "city", nullable = false, length = 50)
	private String city;
	
	@Basic
	@Column(name = "state", nullable = false, length = 50)
	private String state;
	
	@Basic
	@Column(name = "cep", nullable = false, length = 10)
	private String cep;
	
	@Basic
	@Column(name = "igbe_city_code", nullable = false, length = 10)
	private String igbeCityCode;
	
	@Basic
	@Column(name = "igbe_state_code", nullable = false, length = 10)
	private String ibgeStateCode;
	
	@Basic
	@Column(name = "principal", nullable = false, length = 1)
	private String principal;
	
	@Basic
	@Column(name = "delivery", nullable = false, length = 1)
	private String delivery;
	
	@Basic
	@Column(name = "billing", nullable = false, length = 1)
	private String billing;
	
	@Basic
	@Column(name = "correspondence", nullable = false, length = 1)
	private String correspondence;
}
