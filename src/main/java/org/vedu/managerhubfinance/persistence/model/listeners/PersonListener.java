package org.vedu.managerhubfinance.persistence.model.listeners;

import java.util.logging.Logger;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class PersonListener {
	private static final Logger LOGGER = Logger.getLogger(PersonListener.class.getName());
	
	@PostLoad
	public void postLoad(Object o) {
		LOGGER.info("PersonListener.postLoad: " + o.toString());
	}
	
	@PrePersist
	public void prePersist(Object o) {
		LOGGER.info("PersonListener.prePersist: " + o.toString());
	}
	
	@PostPersist
	public void postPersist(Object o) {
		LOGGER.info("PersonListener.postPersist: " + o.toString());
	}
	
	@PreUpdate
	public void preUpdate(Object o) {
		LOGGER.info("PersonListener.preUpdate: " + o.toString());
	}
	
	@PostUpdate
	public void postUpdate(Object o) {
		LOGGER.info("PersonListener.postUpdate: " + o.toString());
	}
	
	@PreRemove
	public void preDelete(Object o) {
		LOGGER.info("PersonListener.preDelete: " + o.toString());
	}

	@PostRemove
	public void postDelete(Object o) {
		LOGGER.info("PersonListener.postDelete: " + o.toString());
	}
}
