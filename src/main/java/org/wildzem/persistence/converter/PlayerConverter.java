package org.wildzem.persistence.converter;


import org.wildzem.model.PlayerModel;
import org.wildzem.persistence.PlayerEntity;


/**
 * 
 * @author Caio
 *
 * @param <PlayerModel> - Model to be converted to Entity
 * @param <PlayerEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class PlayerConverter implements AbstractConverter<PlayerModel, PlayerEntity> {

	
	/**
	 * PlayerEntity to PlayerModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public PlayerModel entityToModel(PlayerEntity entity) {
		
		PlayerModel model = new PlayerModel();
		
		
		// ID
		model.setPlayerId( entity.getPlayerId() );
		
		
		// Attributes
		model.setInGameLogin( entity.getInGameLogin() );
		model.setStatus( entity.getStatus() );
		model.setWinCount( entity.getWinCount() );
		
		
		return model;
	}

	
	/**
	 * PlayerModel to PlayerEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public PlayerEntity modelToEntity(PlayerModel model) {
		
		PlayerEntity entity = new PlayerEntity();
		
		
		// ID
		entity.setPlayerId( model.getPlayerId() );
		
		
		// Attributes
		entity.setInGameLogin( model.getInGameLogin() );
		entity.setStatus( model.getStatus() );
		entity.setWinCount( model.getWinCount() );
		
		
		return entity;
	}

}
