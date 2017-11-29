package org.wildzem.persistence.converter;


import org.wildzem.model.PositionModel;
import org.wildzem.persistence.PositionEntity;


/**
 * 
 * @author Caio
 *
 * @param <PositionModel> - Model to be converted to Entity
 * @param <PositionEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class PositionConverter implements AbstractConverter<PositionModel, PositionEntity> {

	
	/**
	 * PositionEntity to PositionModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public PositionModel entityToModel(PositionEntity entity) {
		
		PositionModel model = new PositionModel();
		
		
		// ID
		model.setPositionId( entity.getPositionId() );
		
		
		// Attributes
		model.setCode( entity.getCode() );
		model.setName( entity.getName() );
		model.setAccessLevel( entity.getAccessLevel() );
		model.setDescription( entity.getDescription() );
		
		
		return model;
	}

	
	/**
	 * PositionModel to PositionEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public PositionEntity modelToEntity(PositionModel model) {
		
		PositionEntity entity = new PositionEntity();
		
		
		// ID
		entity.setPositionId( model.getPositionId() );
			
		
		// Attributes
		entity.setCode( model.getCode() );
		entity.setName( model.getName() );
		entity.setAccessLevel( model.getAccessLevel() );
		entity.setDescription( model.getDescription() );
		
		
		return entity;
	}

}
