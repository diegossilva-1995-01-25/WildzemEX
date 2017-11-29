package org.wildzem.persistence.converter;


import org.wildzem.model.StaffModel;
import org.wildzem.persistence.StaffEntity;


/**
 * 
 * @author Caio
 *
 * @param <StaffModel> - Model to be converted to Entity
 * @param <StaffEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class StaffConverter implements AbstractConverter<StaffModel, StaffEntity> {

	
	/**
	 * StaffEntity to StaffModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public StaffModel entityToModel(StaffEntity entity) {
		
		StaffModel model = new StaffModel();
		PositionConverter posConverter = new PositionConverter();
		
		
		// ID
		model.setStaffId( entity.getId().getStaffId() );
		/*model.getPosition().setPositionId( entity.getId().getStPositionId() );*/
		
		
		// Attributes
		model.setLogin( entity.getLogin() );
		model.setPassword( entity.getPassword() );
		model.setName( entity.getName() );
		model.setEmail( entity.getEmail() );
		model.setStatus( entity.getStatus() );
		
		
		// Position
		model.setPosition( posConverter.entityToModel( entity.getPositionEntity() ) );
		
		
		return model;
	}

	
	/**
	 * StaffModel to StaffEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public StaffEntity modelToEntity(StaffModel model) {
		
		StaffEntity entity = new StaffEntity();
		PositionConverter posConverter = new PositionConverter();
		
		
		// ID
		entity.getId().setStaffId( model.getStaffId() );
		entity.getId().setStPositionId( model.getPosition().getPositionId() );
		
		
		// Attributes
		entity.setLogin( model.getLogin() );
		entity.setPassword( model.getPassword() );
		entity.setName( model.getName() );
		entity.setEmail( model.getEmail() );
		entity.setStatus( model.getStatus() );
		
		
		// Position
		entity.setPositionEntity( posConverter.modelToEntity( model.getPosition() ) );
		
		
		return entity;
	}

}
