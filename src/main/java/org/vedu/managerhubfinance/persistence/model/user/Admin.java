package org.vedu.managerhubfinance.persistence.model.user;

import org.vedu.managerhubfinance.controller.security.RoleType;
import org.vedu.managerhubfinance.persistence.model.PropertiesEntity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
@Entity
public class Admin extends PropertiesEntity {
	@Id
	private String username;
	@Basic
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	@Basic
	@Column(nullable = false, length = 100)
	private String password;
	@Enumerated(EnumType.STRING)
	private RoleType role;
	@Basic
	@Column(length = 100)
	private String token;
	@Basic
	@Column(name= "refresh_token", length = 100)
	private String refreshToken;
}
