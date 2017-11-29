package org.wildzem.persistence.converter;


import org.wildzem.model.TypeModel;
import org.wildzem.persistence.TypeEntity;


/**
 * 
 * @author Caio
 *
 * @param <TypeModel> - Model to be converted to Entity
 * @param <TypeEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class TypeConverter implements AbstractConverter<TypeModel, TypeEntity> {

	
	/**
	 * TypeEntity to TypeModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public TypeModel entityToModel(TypeEntity entity) {
		
		TypeModel model = new TypeModel();
		
		
		// ID
		model.setTypeId( entity.getTypeId() );
		
		
		// Attributes
		model.setCode( entity.getCode() );
		model.setName( entity.getName() );
		model.setDescription( entity.getDescription() );
		
		
		return model;
	}

	
	/**
	 * TypeModel to TypeEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public TypeEntity modelToEntity(TypeModel model) {

		TypeEntity entity = new TypeEntity();
		
		
		// ID
		entity.setTypeId( model.getTypeId() );
		
		
		// Attributes
		entity.setCode( model.getCode() );
		entity.setName( model.getName() );
		entity.setDescription( model.getDescription() );
		
		
		return entity;
	}

}
