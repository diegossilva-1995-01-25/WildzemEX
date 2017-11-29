package org.wildzem.persistence.access;

import java.util.List;

import org.wildzem.model.ResultModel;
import org.wildzem.persistence.ResultEntity;
import org.wildzem.persistence.converter.ResultConverter;

public class ResultDao extends AbstractDao<ResultModel, ResultEntity, ResultConverter> {

	
	public ResultDao() throws InstantiationException, IllegalAccessException {
		super(ResultConverter.class);
	}


	@Override
	public ResultModel select(ResultModel model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ResultModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<ResultModel> selectFiltered(ResultModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
