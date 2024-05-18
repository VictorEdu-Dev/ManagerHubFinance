package org.vedu.managerhubfinance.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;


public class RepositoryTransaction<K, V> {
	
	@PersistenceUnit(unitName = "manager_hub")
	private EntityManagerFactory emf;
	
	public Optional<List<V>> executeFindInTransaction(Function<EntityManager, List<V>> action) {
		EntityTransaction et = null;
		try (EntityManager em = emf.createEntityManager()) {
			et = em.getTransaction();
			et.begin();
			
			List<V> result = action.apply(em);
			
			result.forEach(em::detach);
			et.commit();
			return Optional.ofNullable(result);
		} catch (Exception e) {
			System.err.println("Erro ao tentar obter entidade: " + e.getMessage());
			throw e;
        }
    }
	
	public void executeSaveInTransaction(Consumer<EntityManager> action) {
        EntityTransaction et = null;
        try (EntityManager em = emf.createEntityManager()) {
            et = em.getTransaction();
            et.begin();

            action.accept(em);

            et.commit();
        } catch (Exception e) {
			System.err.println("Erro ao persistir entidade: " + e.getMessage());
			throw e;
        }
    }
	
	public void executeUpdateInTransaction(Consumer<EntityManager> action) {
		EntityTransaction et = null;
		try (EntityManager em = emf.createEntityManager()) {
			et = em.getTransaction();
			et.begin();
			
			action.accept(em);
			
			et.commit();
		} catch (Exception e) {
			System.err.println("Erro ao atualizar entidade: " + e.getMessage());
			throw e;
		}
	}
	
	public void executeDeleteInTransaction(Consumer<EntityManager> action) {
		EntityTransaction et = null;
		try (EntityManager em = emf.createEntityManager()) {
			et = em.getTransaction();
			et.begin();
			
			action.accept(em);
			
			et.commit();
		} catch (Exception e) {
			System.err.println("Erro ao deletar entidade: " + e.getMessage());
			throw e;
		}
	}
}
