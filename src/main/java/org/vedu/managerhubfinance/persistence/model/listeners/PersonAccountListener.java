package org.vedu.managerhubfinance.persistence.model.listeners;

import java.util.logging.Logger;

import jakarta.persistence.PostLoad;

public class PersonAccountListener {
	private static final Logger LOGGER = Logger.getLogger(PersonListener.class.getName());

	@PostLoad
	public void postLoad(Object entity) {
		LOGGER.info("PersonAccount postLoad: " + entity);
	}
}
