package org.vedu.managerhubfinance.persistence.model.groupcompany;

import java.time.LocalDateTime;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"address", "phones", "contact"})
@Builder
@Table(name = "company")
@Entity
public class Company extends PropertiesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	@Column(name = "corporate_name", nullable = false, length = 50)
	private String corporateName;
	
	@Basic
	@Column(name = "fantasy_name", nullable = false, length = 50)
    private String fantasyName;
	
	@Basic
	@Column(name = "cnpj", nullable = false, length = 20)
    private String cnpj;
	
	@OneToMany(
			mappedBy = "company",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
    private List<CompanyAddress> address;
	
	@OneToMany(
			mappedBy = "company",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
    private List<CompanyPhone> phones;
	
	@OneToMany(
			mappedBy = "company",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
    private List<CompanyContact> contact;
	
	@Basic
	@Column(name = "registration_state", nullable = false, length = 2)
    private String registrationState;
	
	@Basic
	@Column(name = "registration_city", nullable = false, length = 50)
    private String registrationCity;
	
	@Basic
	@Column(name = "registration_district", nullable = false, length = 50)
    private String website;
	
	@Basic
	@Column(name = "email", nullable = false, length = 50)
    private String regimeType;
	
	@Basic
	@Column(name = "crt", nullable = false, length = 50)
    private String crt;
	
	@Basic
	@Column(name = "foundation_date", nullable = false)
    private LocalDateTime foundationDate;
	
	@Basic
	@Column(name = "type", nullable = false, length = 50)
    private String type;
	
	@Basic
	@Column(name = "commercial_registry_enrollment", nullable = false, length = 50)
    private String commerciaRegistryEnrollment;
	
	@Basic
	@Column(name = "registration_entollment_date", nullable = false)
    private LocalDateTime registrationEntollmentDate;
	
	@Basic
	@Column(name = "state_registration", nullable = false, length = 50)
    private String ibgeCityCode;
	
	@Basic
	@Column(name = "state_ibge_code", nullable = false, length = 50)
    private String stateIbgeCode;
	
	@Basic
	@Column(name = "state_registration_date", nullable = false)
    private String cei;
	
	@Basic
	@Column(name = "cei", nullable = false, length = 50)
    private String cnae;
    

}
