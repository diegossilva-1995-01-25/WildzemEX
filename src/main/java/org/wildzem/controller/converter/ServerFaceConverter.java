package org.wildzem.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.wildzem.model.ServerModel;
import org.wildzem.persistence.access.ServerDao;

@FacesConverter("serverConverter")
public class ServerFaceConverter implements Converter {

	
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
    	ServerDao dao = null;
    	
		try {
			
			dao = new ServerDao();
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
        
        ServerModel server = null;
        
        if (value instanceof ServerModel) {
            
            server = (ServerModel) value;
            String key = Byte.toString( server.getServerId() );
            
            return key;
        }
        
        return "";
    }

}
