package org.wildzem.persistence.access;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.wildzem.model.CharacterModel;
import org.wildzem.persistence.CharacterEntity;
import org.wildzem.persistence.converter.CharacterConverter;
import org.wildzem.utils.CommonOperations;


public class CharacterDao extends AbstractDao<CharacterModel, CharacterEntity, CharacterConverter> {

	
	public CharacterDao() throws InstantiationException, IllegalAccessException {
		super(CharacterConverter.class);
	}


	@Override
	public CharacterModel select(CharacterModel model) {
		
		entityManager = CommonOperations.getManagerInstance();
		CharacterEntity entity = absConverter.modelToEntity( model );	
		
		return absConverter.entityToModel( entityManager.find(CharacterEntity.class, entity.getId()) );
	}


	
	@Override
	@SuppressWarnings("unchecked")
	public List<CharacterModel> selectAll() {
		
		// Creating Query
		entityManager = CommonOperations.getManagerInstance();
		Query query = entityManager.createNamedQuery("CharacterEntity.findAll");
		query.setMaxResults(100);
		
		
		// Creating Entity list to receive query result and Model list to be returned
		List<CharacterEntity> entities = query.getResultList();
		List<CharacterModel> models = new LinkedList<>();
		
		
		// Converting Entity list to Model list
		for (CharacterEntity entity : entities) models.add( absConverter.entityToModel( entity ) );
		
		
		return models;
	}

	
	@Override
	public List<CharacterModel> selectFiltered(CharacterModel model) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
