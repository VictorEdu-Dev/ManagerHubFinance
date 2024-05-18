package org.vedu.managerhubfinance.persistence.repository;

import java.util.List;

/**
 * This interface defines the contract for a CRUD repository.
 * It is a generic interface that can be used with any type of primary key (K) and entity class (V).
 *
 * @param <K> the type of the primary key
 * @param <V> the type of the entity class
 */
public interface CrudRepository<K, V> {
	/**
	  * This method is used to find a single entity in the repository.
	  *
	  * @param key the key of the entity to find
	  * @param entity the class of the entity to find
	  * @return the found entity
	  */
	public V findSingleEntity(K key, Class<V> entity);
	
	/**
	  * This method is used to find a list of entities in the repository.
	  *
	  * @param entity the class of the entities to find
	  * @return the list of found entities
	  */
	public List<V> findListEntity(Class<V> entity);
	
	/**
	  * This method is used to save an entity in the repository.
	  *
	  * @param entity the entity to save
	  */
	public void save(V entity);
	
	 /**
	  * This method is used to save a list of entities in the repository.
	  *
	  * @param entities the list of entities to save
	  */
	public void saveAll(List<V> entities);
	
	/**
	 * This method is used to update an entity in the repository.
	 *
	 * @param entity the entity to update
	 */
	public void update(V entity);
	
	/**
	 * This method is used to update a list of entities in the repository.
	 *
	 * @param entities the list of entities to update
	 */
	public void updateAll(List<V> entities);
	
	/**
	 * This method is used to delete an entity from the repository.
	 *
	 * @param entity the entity to delete
	 */
	public void delete(V entity);
	
	/**
	 * This method is used to delete a list of entities from the repository.
	 *
	 * @param entities the list of entities to delete
	 */
	public void deleteAll(List<V> entities);
	
}
