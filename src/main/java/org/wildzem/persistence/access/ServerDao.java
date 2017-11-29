package org.wildzem.persistence.access;

import java.util.List;

import org.wildzem.model.ServerModel;
import org.wildzem.persistence.ServerEntity;
import org.wildzem.persistence.converter.ServerConverter;

public class ServerDao extends AbstractDao<ServerModel, ServerEntity, ServerConverter>{

	
	public ServerDao() throws InstantiationException, IllegalAccessException {
		super(ServerConverter.class);
	}


	@Override
	public ServerModel select(ServerModel model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ServerModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<ServerModel> selectFiltered(ServerModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
