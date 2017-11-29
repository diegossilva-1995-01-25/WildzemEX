package org.wildzem.persistence.converter;


import org.wildzem.model.CharacterModel;
import org.wildzem.persistence.CharacterEntity;


/**
 * 
 * @author Caio
 *
 * @param <CharacterModel> - Model to be converted to Entity
 * @param <CharacterEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class CharacterConverter implements AbstractConverter<CharacterModel, CharacterEntity> {

	
	/**
	 * CharacterEntity to CharacterModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public CharacterModel entityToModel(CharacterEntity entity) {

		CharacterModel model = new CharacterModel();
		
		ServerConverter serConverter = new ServerConverter();
		PlayerConverter plaConverter = new PlayerConverter();
		
		
		// ID
		model.setCharacterId( entity.getId().getCharacterId() );
		/*model.getServer().setServerId( entity.getId().getChServerId() );
		  model.getPlayer().setPlayerId( entity.getId().getChPlayerId() );*/
		
		
		// Attributes
		model.setName( entity.getName() );
		
		
		// Server
		model.setServer( serConverter.entityToModel( entity.getServerEntity() ) );
		
		
		// Player
		model.setPlayer( plaConverter.entityToModel( entity.getPlayerEntity() ) );
		
		
		return model;
	}

	
	/**
	 * CharacterModel to CharacterEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public CharacterEntity modelToEntity(CharacterModel model) {

		CharacterEntity entity = new CharacterEntity();
		
		ServerConverter serConverter = new ServerConverter();
		PlayerConverter plaConverter = new PlayerConverter();
		
		
		// ID
		entity.getId().setCharacterId( model.getCharacterId() );
		entity.getId().setChServerId( model.getServer().getServerId() );
		entity.getId().setChPlayerId( model.getPlayer().getPlayerId() );
		
		
		// Attribute
		entity.setName( model.getName() );
			
		
		// Server
		entity.setServerEntity( serConverter.modelToEntity( model.getServer() ) );
			
		
		// Player
		entity.setPlayerEntity( plaConverter.modelToEntity( model.getPlayer() ) );
		
		
		return entity;
	}

}
