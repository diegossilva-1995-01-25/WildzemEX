package org.wildzem.persistence.access;

import java.util.List;

import javax.persistence.Query;

import org.wildzem.model.StaffModel;
import org.wildzem.persistence.StaffEntity;
import org.wildzem.persistence.converter.AbstractConverter;
import org.wildzem.persistence.converter.StaffConverter;
import org.wildzem.utils.CommonOperations;

public class StaffDao extends AbstractDao<StaffModel, StaffEntity, StaffConverter> {

	
	public StaffDao() throws InstantiationException, IllegalAccessException {
		super(StaffConverter.class);
	}
	
	
	@Override
	public StaffModel select(StaffModel model) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<StaffModel> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<StaffModel> selectFiltered(StaffModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
     * 
     * Verifies the login sent by the login.xhtml page by finding Staff member
     * by Username and Password.
     * 
     * @param model: Object originated from login.xhtml
     * 
     * @return Returns the full record if the Query is positive, else it returns null
     */
    public StaffModel validateLogin(StaffModel model) {
           
    	AbstractConverter<StaffModel, StaffEntity> staConverter = new StaffConverter();
    	
        try {
            
        	// Creating login query
            Query query = CommonOperations.getManagerInstance().createNamedQuery("StaffEntity.validate");
            query.setParameter("login", model.getLogin());
            query.setParameter("pass", model.getPassword());
            
            // Return converted Entity to Model
            return staConverter.entityToModel( (StaffEntity) query.getSingleResult() );
            
        }
        catch (Exception e) {

            return null;
        }
    }


}
