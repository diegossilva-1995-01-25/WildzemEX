package org.wildzem.persistence.converter;


import org.wildzem.model.EventModel;
import org.wildzem.persistence.EventEntity;


/**
 * 
 * @author Caio
 *
 * @param <EventModel> - Model to be converted to Entity
 * @param <EventEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class EventConverter implements AbstractConverter<EventModel, EventEntity> {

	
	/**
	 * EventEntity to EventModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public EventModel entityToModel(EventEntity entity) {
		
		EventModel model = new EventModel();		
		StaffConverter staConverter = new StaffConverter();
		
		
		// ID
		model.setEventId( entity.getId().getEventId()  );
		/*model.getStaff().setStaffId( entity.getId().getEvStaffId() );
		  model.getStaff().getPosition().setPositionId( entity.getId().getEvPositionId() );*/
		
		
		// Attributes
		model.setDate( entity.getDate() );
		model.setStartTime( entity.getStartTime() );
		model.setEndTime( entity.getEndTime() );
		
		
		// Staff
		model.setStaff( staConverter.entityToModel( entity.getStaffEntity() ) );
		
		
		return model;
	}

	
	/**
	 * EventModel to EventEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public EventEntity modelToEntity(EventModel model) {
		
		EventEntity entity = new EventEntity();
		StaffConverter staConverter = new StaffConverter();
		
		
		// ID
		entity.getId().setEventId( model.getEventId() );
		entity.getId().setEvStaffId( model.getStaff().getStaffId() );
		entity.getId().setEvPositionId( model.getStaff().getPosition().getPositionId() );
		
		
		// Attributes
		entity.setDate( model.getDate() );
		entity.setStartTime( model.getStartTime() );
		entity.setEndTime( model.getEndTime() );
		
		
		// Staff
		entity.setStaffEntity( staConverter.modelToEntity( model.getStaff() ) );
		
		
		return entity;
	}

}
