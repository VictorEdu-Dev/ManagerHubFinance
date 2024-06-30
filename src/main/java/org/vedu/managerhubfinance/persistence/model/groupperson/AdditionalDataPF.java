package org.vedu.managerhubfinance.persistence.model.groupperson;

import java.time.LocalDateTime;

import org.vedu.managerhubfinance.persistence.model.Situation;
import org.vedu.managerhubfinance.persistence.model.groupcollaborator.Seller;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public final class AdditionalDataPF extends AdditionalData {
	
	@Basic
	@Column(name = "marital_status", length = 30)
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
	
	@Basic
	@Column(name = "profession", length = 50)
	private String profession;
	
	@Basic
	@Column(name = "gender", length = 1)
	private String gender;
	
	@Basic
	@Column(name = "birth_date")
	private LocalDateTime birthDate;
	
	@Basic
	@Column(name = "birthplace", length = 50)
	private String birthplace;
	
	@Basic
	@Column(name = "father_name", length = 100)
	private String fatherName;
	
	@Basic
	@Column(name = "father_cpf", length = 20)
	private String fatherCpf;
	
	@Basic
	@Column(name = "mother_name", length = 100)
	private String motherName;
	
	@Basic
	@Column(name = "mother_cpf", length = 20)
	private String motherCpf;
	
	@Basic
	@Column(name = "contract_type", length = 15)
	private ContactType contractType;
	
	@Basic
	@Column(name = "situation", length = 15)
	private Situation situation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
	@Basic
	@Column(name = "standard_operation_nature", length = 100)
	private String standardOperationNature;
	
}
