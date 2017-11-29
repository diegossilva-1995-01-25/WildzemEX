package org.wildzem.persistence.access;

import java.util.List;

import org.wildzem.model.TypeModel;
import org.wildzem.persistence.TypeEntity;
import org.wildzem.persistence.converter.TypeConverter;

public class TypeDao extends AbstractDao<TypeModel, TypeEntity, TypeConverter> {

	
	public TypeDao() throws InstantiationException, IllegalAccessException {
		super(TypeConverter.class);
	}


	@Override
	public TypeModel select(TypeModel model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TypeModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<TypeModel> selectFiltered(TypeModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
