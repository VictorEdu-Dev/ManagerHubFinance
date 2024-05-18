package org.vedu.managerhubfinance.persistence.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PersonAccountId {
	@Basic
	@Column(name = "username", nullable = false, length = 20, unique = true)
	private String username;
	
	@Basic
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	
	@Basic
	@Column(name = "phone_number", nullable = false, length = 20, unique = true)
	private String phoneNumber;
}
