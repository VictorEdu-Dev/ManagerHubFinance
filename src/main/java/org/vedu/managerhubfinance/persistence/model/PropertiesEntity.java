package org.vedu.managerhubfinance.persistence.model;

import java.time.LocalDateTime;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class PropertiesEntity {
	@Version
	private LocalDateTime version;
}
