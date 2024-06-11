package org.vedu.managerhubfinance.service.transaction;

import java.util.function.Consumer;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import lombok.Data;

@Data
public class RepositoryTransaction<E> {
	
	private EntityManager entityManager;
	
	public void runInTransaction(Consumer<EntityManager> action) {
        try (EntityManager em = entityManager) {
            em.getTransaction().begin();

            action.accept(em);

            em.getTransaction().commit();
        } catch (Exception e) {
			System.err.println("Erro ao executar transação: " + e.getMessage());
			throw e;
        }
    }
	
	public E callInTransaction(Function<EntityManager, E> action) {
        try (EntityManager em = entityManager) {
            em.getTransaction().begin();

            E result = action.apply(em);

            em.getTransaction().commit();
            return result;
        } catch (Exception e) {
            System.err.println("Erro ao executar transação: " + e.getMessage());
            return null;
        }
	}
}
