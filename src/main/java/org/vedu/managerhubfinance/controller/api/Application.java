package org.vedu.managerhubfinance.controller.api;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager_hub");
        System.out.println("factory is open: " + emf.isOpen());
        
		emf.close();
		System.out.println("factory is open: " + emf.isOpen());
	}
}
