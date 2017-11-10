package wildzem.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wildzem.model.Server;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.ServerDAO;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 */

@ViewScoped
@Named(value="serverController")
public class ServerController implements Serializable, GenericController<Server> {
    private static final long serialVersionUID = 1L;
    
    
    @Inject private Server currentServer;
    @Inject private GenericDAO<Server, String> serverDao;
    
    @Produces private List<Server> serverList;
    
    
    /*
     * Creates a new instance of StaffBean
     * 
     * init will initialize the Generic DAO as one of it's implementations in order
     * populate the object list.
     */
    public ServerController() {
    }
    
    @PostConstruct
    public void init() {
        
        serverDao = new ServerDAO();
        serverList = serverDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        serverDao.insert(currentServer);
        CommonOperations.message(currentServer.getLocation() + " was added successfully!");
        currentServer = new Server();
    }

    @Override
    public void editRecord(Server server) {
        
        currentServer = server;
    }

    @Override
    public void updateRecord() {
        
        serverDao.update(currentServer);
        init();
    }

    @Override
    public void deleteRecord(Server server) {
        
        serverDao.delete( server.getCode() );
        serverList.remove(server);
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */  

    public Server getCurrentServer() {
        return currentServer;
    }
    public void setCurrentServer(Server currentServer) {
        this.currentServer = currentServer;
    }

    
    public List<Server> getServerList() {
        return serverList;
    }
    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }
    
}
