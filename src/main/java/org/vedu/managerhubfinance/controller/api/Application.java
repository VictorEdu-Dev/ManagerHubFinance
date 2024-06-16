package org.vedu.managerhubfinance.controller.api;

import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
	public static void main(String[] args) throws IOException, CsvException {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager_hub")) {
			
		} catch (Exception e) {
		    System.err.println("Erro: " + e.getMessage());
		}
        System.out.println("End of program");
	}
}
