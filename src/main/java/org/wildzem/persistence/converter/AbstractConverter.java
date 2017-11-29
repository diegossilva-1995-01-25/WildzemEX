package org.wildzem.persistence.converter;


/**
 * 
 * @author Caio
 *
 * @param <T> - Model to be converted to Entity
 * @param <E> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public interface AbstractConverter <T, E> {

	
	/**
	 * Entity to Model converter
	 * 
	 * @param entity
	 * @return
	 */
	T entityToModel(E entity);
	
	
	/**
	 * Model to Entity converter
	 * 
	 * @param model
	 * @return
	 */
	E modelToEntity(T model);
}
