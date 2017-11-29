package org.wildzem.persistence.access;


import java.util.List;

import javax.persistence.EntityManager;

import org.wildzem.persistence.converter.AbstractConverter;
import org.wildzem.utils.CommonOperations;


/**
*
* @author Caio
* @version 1.0
* 
* Generic DAO to hold the methods any other DAO implementing it. Since the methods
* are very basic there's no need to implement them in each DAO.
* 
* @param <T>: Type of object to be used in the implementation
* @param <E>: Type of entity to be used in the implementation
* @param <C>: Type of converter to be used in the implementation
* @param <K>: Type of primary key to be used in the implementation
*/
public abstract class AbstractDao<T, E, C> {

	
	protected EntityManager entityManager;
	protected AbstractConverter<T,E> absConverter;

	
	/**
     * Blank constructor
     */
    protected AbstractDao() {
    }
 
    
    /**
     * Constructor to initiate the generic Class T by using an actual Object.class
     * provided by the DAO implementation. This will further be used on the select method.
     * 
     * @param persistedClass: Provided by the DAO implementation.
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    @SuppressWarnings("unchecked")
	protected AbstractDao(Class<C> converter) throws InstantiationException, IllegalAccessException {
        
    	this();
        this.absConverter = (AbstractConverter<T, E>) converter.newInstance();       
    }
	
	
    /**
     * Basic JPA insertion with a generic object.
     * 
     * @param object: generic object
     */
	public void insert(T model) {
		
		entityManager = CommonOperations.getManagerInstance();
		
		E entity = absConverter.modelToEntity( model );
		entityManager.persist(entity);
	}
	
	
	/**
     * Basic JPA update with a generic object.
     * 
     * @param object: generic object
     */
	public void update(T model) {
		
		entityManager = CommonOperations.getManagerInstance();
		
		E entity = absConverter.modelToEntity( model );
		entityManager.merge(entity);
	}
	
	
	/**
     * Basic JPA deletion with a generic key.
     * 
     * @param key: generic key
     */
	public void delete(T model) {
		
		entityManager = CommonOperations.getManagerInstance();
		
		E entity = absConverter.modelToEntity( model );
		
		entityManager.remove(entity);
	}
	
	
	/**
     * Basic JPA select method. This method makes use of the generic Class
     * initialized by the constructor to identify which Object it should look for
     * in the Database.
     * 
     * @param model: Generic model object.
     * 
     * @return Makes use of provided JPA method find() to locate a record 
     * via key and returns said record.
     */
	public abstract T select(T model);
	
	
	/**
     * Basic JPA select all method. This method makes use of the generic Class
     * initialized by the constructor to identify which Object it should look for
     * in the Database.
     * 
     * @return By making use of the provided class it creates a query that will 
     * return a list of T.
     */
	public abstract List<T> selectAll();
	
	
	/**
	 * Select list of records by a given parameter
	 * 
	 * @param entity - depends on implementation
	 * @return  - depends on implementation
	 */
	public abstract List<T> selectFiltered(T model);
	
}
