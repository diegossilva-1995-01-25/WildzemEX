package org.wildzem.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.wildzem.model.PositionModel;
import org.wildzem.persistence.access.PositionDao;

@FacesConverter("staffPositionConverter")
public class PositionFaceConverter implements Converter {

	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    
    	PositionDao dao = null;
    	
		try {
			
			dao = new PositionDao();			
		} 
		catch (InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
		}
		
        Byte key = Byte.parseByte(value);
        
        //return dao.select(key);
        return null;
    }

    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        PositionModel position = null;
        
        if (value instanceof PositionModel) {
            
            position = (PositionModel) value;
            String key = Byte.toString( position.getPositionId() );
            
            return key;
        }
        
        return "";
    }

}
