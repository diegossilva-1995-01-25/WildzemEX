package org.wildzem.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.wildzem.model.ServerModel;
import org.wildzem.persistence.access.ServerDao;
import org.wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 * @version 0.5
 */
@ViewScoped
@Named(value="serverController")
public class ServerController implements Serializable, AbstractController<ServerModel> {
    
    
    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = 6729206267290381822L;
	
	
	/*
	 * Attributes section
	 */
	@Inject private ServerModel currentServer;
    private ServerDao serverDao;
    
    @Produces 
    @Named("serverList")
    private List<ServerModel> serverList;
    
    
    /*
     * Creates a new instance of ServerController
     * 
     * init will initialize the Generic DAO as one of it's implementations in order
     * populate the object list.
     */
    public ServerController() {
    }
    
    @PostConstruct
    public void init() {
        
        try {
			
        	serverDao = new ServerDao();
		} 
        catch (InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
		}
        
        serverList = serverDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        serverDao.insert(currentServer);
        CommonOperations.message(currentServer.getLocation() + " was added successfully!");
        currentServer = new ServerModel();
    }

    @Override
    public void editRecord(ServerModel server) {
        
        currentServer = server;
    }

    @Override
    public void updateRecord() {
        
        serverDao.update(currentServer);
        init();
    }

    @Override
    public void deleteRecord(ServerModel server) {
        
        serverDao.delete( server );
        serverList.remove( server );
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */  
    public ServerModel getCurrentServer() {
        return currentServer;
    }
    public void setCurrentServer(ServerModel currentServer) {
        this.currentServer = currentServer;
    }

    
    public List<ServerModel> getServerList() {
        return serverList;
    }
    public void setServerList(List<ServerModel> serverList) {
        this.serverList = serverList;
    }
    
}
