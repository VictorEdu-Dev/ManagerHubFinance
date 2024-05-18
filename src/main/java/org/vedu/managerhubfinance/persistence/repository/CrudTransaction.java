package org.vedu.managerhubfinance.persistence.repository;

import org.vedu.managerhubfinance.service.impl.RepositoryTransaction;

/**
 * This interface defines the contract for a CRUD transaction.
 * It is a generic interface that can be used with any type of primary key (K) and entity class (V).
 *
 * @param <K> the type of the primary key
 * @param <V> the type of the entity class
 */
public interface CrudTransaction<K, V> {
	/**
	  * This method is used to get a transaction for the repository.
	  * The transaction is represented by an instance of RepositoryTransaction.
	  *
	  * @return an instance of RepositoryTransaction
	  */
	public RepositoryTransaction<K, V> getTransaction();
}
