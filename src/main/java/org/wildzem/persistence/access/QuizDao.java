package org.wildzem.persistence.access;

import java.util.List;

import org.wildzem.model.QuizModel;
import org.wildzem.persistence.QuizEntity;
import org.wildzem.persistence.converter.QuizConverter;

public class QuizDao extends AbstractDao<QuizModel, QuizEntity, QuizConverter> {

	
	public QuizDao() throws InstantiationException, IllegalAccessException {
		super(QuizConverter.class);
	}


	@Override
	public QuizModel select(QuizModel model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<QuizModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<QuizModel> selectFiltered(QuizModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
