package org.wildzem.persistence.access;

import java.util.List;

import org.wildzem.model.PlayerModel;
import org.wildzem.persistence.PlayerEntity;
import org.wildzem.persistence.converter.PlayerConverter;

public class PlayerDao extends AbstractDao<PlayerModel, PlayerEntity, PlayerConverter>{

	
	public PlayerDao() throws InstantiationException, IllegalAccessException {
		super(PlayerConverter.class);
	}


	@Override
	public PlayerModel select(PlayerModel model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PlayerModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<PlayerModel> selectFiltered(PlayerModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
