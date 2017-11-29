package org.wildzem.persistence.converter;


import org.wildzem.model.ResultModel;
import org.wildzem.persistence.ResultEntity;


/**
 * 
 * @author Caio
 *
 * @param <ResultModel> - Model to be converted to Entity
 * @param <ResultEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class ResultConverter implements AbstractConverter<ResultModel, ResultEntity> {

	
	/**
	 * ResultEntity to ResultModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public ResultModel entityToModel(ResultEntity entity) {
		
		ResultModel model = new ResultModel();
		
		EventConverter eveConverter = new EventConverter();
		CharacterConverter chaConverter = new CharacterConverter();
		
		
		// ID
		model.setResultId( entity.getId().getWinnerId() );
		/*model.getEvent().setEventId( entity.getId().getWnEventId() );
		
		  model.getEvent().getStaff().setStaffId( entity.getId().getWnStaffId() );
		  model.getEvent().getStaff().getPosition().setPositionId( entity.getId().getWnPositionId() );;
		
		  model.getCharacter().setCharacterId( entity.getId().getWnCharacterId() );
		  model.getCharacter().getPlayer().setPlayerId( entity.getId().getWnPlayerId() );
		  model.getCharacter().getServer().setServerId( entity.getId().getWnServerId() );*/
		
		
		// Attributes
		model.setPrize( entity.getPrize() );
		model.setStatus( entity.getPrize() );
		
		
		// Event
		model.setEvent( eveConverter.entityToModel( entity.getEventEntity() ) );
		
		
		// Character
		model.setCharacter( chaConverter.entityToModel( entity.getPlayerCharacterEntity() ) );
		
		
		return model;
	}

	
	/**
	 * ResultModel to ResultEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public ResultEntity modelToEntity(ResultModel model) {
		
		ResultEntity entity = new ResultEntity();
		
		EventConverter eveConverter = new EventConverter();
		CharacterConverter chaConverter = new CharacterConverter();
		
		
		// ID
		entity.getId().setWinnerId( model.getResultId() );
		entity.getId().setWnEventId( model.getEvent().getEventId() );
		
		entity.getId().setWnStaffId( model.getEvent().getStaff().getStaffId() );
		entity.getId().setWnPositionId( model.getEvent().getStaff().getPosition().getPositionId() );
		
		entity.getId().setWnCharacterId( model.getCharacter().getCharacterId() );
		entity.getId().setWnPlayerId( model.getCharacter().getPlayer().getPlayerId() );
		entity.getId().setWnServerId( model.getCharacter().getServer().getServerId() );
		
		
		// Attributes
		entity.setPrize( model.getPrize() );
		entity.setStatus( model.getStatus() );
			
		
		// Event
		entity.setEventEntity( eveConverter.modelToEntity( model.getEvent() ) );
		
		// Character
		entity.setPlayerCharacterEntity( chaConverter.modelToEntity( model.getCharacter() ) );
		
		
		return entity;
	}

}
