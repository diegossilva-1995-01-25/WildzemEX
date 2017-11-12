package wildzem.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import wildzem.model.Server;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.ServerDAO;

@FacesConverter("serverConverter")
public class ServerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        System.out.println("SC " + value);
        
        GenericDAO<Server, String> dao = new ServerDAO();
        Server server = (Server) dao.select(value);
        
        return server;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Server server = null;
        
        if (value instanceof Server) {
            
            server = (Server) value;
            return server.getCode();
        }
        
        return "";
    }

}
