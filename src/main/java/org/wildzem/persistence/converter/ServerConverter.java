package org.wildzem.persistence.converter;


import org.wildzem.model.ServerModel;
import org.wildzem.persistence.ServerEntity;


/**
 * 
 * @author Caio
 *
 * @param <ServerModel> - Model to be converted to Entity
 * @param <ServerEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class ServerConverter implements AbstractConverter<ServerModel, ServerEntity> {

	
	/**
	 * ServerEntity to ServerModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public ServerModel entityToModel(ServerEntity entity) {
		
		ServerModel model = new ServerModel();
		
		
		// ID
		model.setServerId( entity.getServerId() );
		
		
		// Attributes
		model.setCode( entity.getCode() );
		model.setLocation( entity.getLocation() );
		model.setStatus( entity.getStatus() );
		
		
		return model;
	}

	
	/**
	 * ServerModel to ServerEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public ServerEntity modelToEntity(ServerModel model) {
		
		ServerEntity entity = new ServerEntity();
		
		
		// ID
		entity.setServerId( model.getServerId() );
			
		
		// Attributes
		entity.setCode( model.getCode() );
		entity.setLocation( model.getLocation() );
		entity.setStatus( model.getStatus() );
		
		
		return entity;
	}

}
