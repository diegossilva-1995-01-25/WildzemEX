package org.wildzem.persistence.access;

import java.util.List;

import org.wildzem.model.EventModel;
import org.wildzem.persistence.EventEntity;
import org.wildzem.persistence.converter.EventConverter;

public class EventDao extends AbstractDao<EventModel, EventEntity, EventConverter> {

	
	public EventDao() throws InstantiationException, IllegalAccessException {
		super(EventConverter.class);
	}


	@Override
	public EventModel select(EventModel model) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<EventModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<EventModel> selectFiltered(EventModel model) {
		// TODO Auto-generated method stub
		return null;
	}

}
