package org.vedu.managerhubfinance.controller.api;

import java.io.IOException;

import org.vedu.managerhubfinance.persistence.model.groupbasic.Cep;
import org.vedu.managerhubfinance.persistence.model.groupperson.Person;
import org.vedu.managerhubfinance.persistence.model.groupperson.PersonAddress;
import org.vedu.managerhubfinance.persistence.repository.base.impl.CepDAOImpl;
import org.vedu.managerhubfinance.service.transaction.RepositoryTransaction;

import com.opencsv.exceptions.CsvException;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
	private static Cep cep;
	
	public static void main(String[] args) throws IOException, CsvException {
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager_hub")) {
			
			RepositoryTransaction<Cep> rt = new RepositoryTransaction<>();
			rt.setEntityManager(emf.createEntityManager());
			
			CepDAOImpl cepDao = CepDAOImpl.getInstance();
			
			cep = rt.callInTransaction(em -> {
				return cepDao.findSingleEntity("62010560").get();
			});
			
			PersonAddress pa = PersonAddress
					.builder()
					.numberCep(cep)
					.city(cep.getCity())
					.state(cep.getCity().getState())
					.billing("N")
					.delivery("Y")
					.correspondence("Y")
					.complement("Apto 201")
					.number("199")
					.neighborhood("Centro")
					.publicPlace("")
					.build();
			
			Person p = Person
					.builder()
					.name("Victor Eduardo Pita Campos")
					.site("VictorEdu-Dev.github.io")
					.personAddress(pa)
					.build();

		} catch (Exception e) {
		    System.err.println("Erro: " + e.getMessage());
		}
        System.out.println("End of program");
	}
}
