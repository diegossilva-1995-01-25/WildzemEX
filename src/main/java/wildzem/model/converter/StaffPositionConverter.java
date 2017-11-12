package wildzem.model.converter;

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
        
        System.out.println("SPC " + value);
        
        GenericDAO<StaffPosition, String> dao = new StaffPositionDAO();
        StaffPosition sp = (StaffPosition) dao.select(value);

        return sp;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        StaffPosition staffPosition = null;
        
        if (value instanceof StaffPosition) {
            
            staffPosition = (StaffPosition) value;
            return staffPosition.getCode();
        }
        
        return "";
    }

}
