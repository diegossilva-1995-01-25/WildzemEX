package wildzem.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import wildzem.model.Server;
import wildzem.persistence.ServerDAO;

/**
 *
 * @author Caio
 */

@ViewScoped
@Named(value="serverController")
public class ServerController extends GenericController<Server, Integer, ServerDAO> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public ServerController() {
        super(Server.class, ServerDAO.class);
    }
}
