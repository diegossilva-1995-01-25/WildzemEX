package org.wildzem.persistence.converter;


import org.wildzem.model.QuizModel;
import org.wildzem.persistence.QuizEntity;


/**
 * 
 * @author Caio
 *
 * @param <QuizModel> - Model to be converted to Entity
 * @param <QuizEntity> - Entity to be converted to Model
 * 
 * @version 1.0
 */
public class QuizConverter implements AbstractConverter<QuizModel, QuizEntity> {

	
	/**
	 * QuizEntity to QuizModel converter
	 * 
	 * @param entity
	 * @return
	 */
	@Override
	public QuizModel entityToModel(QuizEntity entity) {
		
		QuizModel model = new QuizModel();
		
		StaffConverter staConverter = new StaffConverter();
		TypeConverter typConverter = new TypeConverter();
		
		
		// ID
		model.setQuestionId( entity.getId().getQuestionId() );
		/*model.getStaff().setStaffId( entity.getId().getQuStaffId() );
		  model.getStaff().getPosition().setPositionId( entity.getId().getQuPositionId() );
		  model.getType().setTypeId( entity.getId().getQuTypeId() );*/
		
		
		// Attributes
		model.setQuestion( entity.getQuestion() );
		model.setAnswer( entity.getAnswer() );
		model.setUses( entity.getUses() );
		model.setShared( entity.isShared() );
		
		
		// Staff
		model.setStaff( staConverter.entityToModel( entity.getStaffEntity() ) );
		
		
		// Type
		model.setType( typConverter.entityToModel( entity.getQuizTypeEntity() ) );
		
		
		return model;
	}

	
	/**
	 * QuizModel to QuizEntity converter
	 * 
	 * @param model
	 * @return
	 */
	@Override
	public QuizEntity modelToEntity(QuizModel model) {
		
		QuizEntity entity = new QuizEntity();
		
		StaffConverter staConverter = new StaffConverter();
		TypeConverter typConverter = new TypeConverter();
		
		
		// ID
		entity.getId().setQuestionId( model.getQuestionId() );
		entity.getId().setQuStaffId( model.getStaff().getStaffId() );
		entity.getId().setQuPositionId( model.getStaff().getPosition().getPositionId() );
		entity.getId().setQuTypeId( model.getType().getTypeId() );
		
		
		// Attributes
		entity.setQuestion( model.getQuestion() );
		entity.setAnswer( model.getAnswer() );
		entity.setUses( model.getUses() );
		entity.setShared( model.isShared() );
		
		
		// Staff
		entity.setStaffEntity( staConverter.modelToEntity( model.getStaff() ) );
		
		
		// Type
		entity.setQuizTypeEntity( typConverter.modelToEntity( model.getType() ) );
		
		
		return entity;
	}

}
