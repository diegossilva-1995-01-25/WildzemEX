package org.wildzem.persistence.access;

import java.util.List;

import org.wildzem.model.PositionModel;
import org.wildzem.persistence.PositionEntity;
import org.wildzem.persistence.converter.PositionConverter;

public class PositionDao extends AbstractDao<PositionModel, PositionEntity, PositionConverter> {

	
	public PositionDao() throws InstantiationException, IllegalAccessException {
		super(PositionConverter.class);
	}


	@Override
	public PositionModel select(PositionModel model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PositionModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<PositionModel> selectFiltered(PositionModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
