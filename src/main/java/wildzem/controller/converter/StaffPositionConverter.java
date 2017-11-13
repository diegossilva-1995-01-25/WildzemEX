package wildzem.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import wildzem.model.StaffPosition;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.StaffPositionDAO;

@FacesConverter("staffPositionConverter")
public class StaffPositionConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    
        GenericDAO<StaffPosition, Byte> dao = new StaffPositionDAO();
        Byte key = Byte.parseByte(value);
        
        return dao.select(key);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        StaffPosition staffPosition = null;
        
        if (value instanceof StaffPosition) {
            
            staffPosition = (StaffPosition) value;
            String key = Byte.toString( staffPosition.getId() );
            
            return key;
        }
        
        return "";
    }

}
