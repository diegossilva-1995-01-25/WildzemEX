package org.wildzem.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.wildzem.model.PlayerModel;
import org.wildzem.persistence.access.PlayerDao;

/**
 *
 * @author Caio
 * @version 0.5
 */
@ViewScoped
@Named(value="playerController")
public class PlayerController implements Serializable, AbstractController<PlayerModel> {
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -2913089991475271560L;
	  
    
    /*
	 * Attribute section
	 */
    @Inject private PlayerModel currentPlayer;
    private PlayerDao playerDao;
    
    @Produces 
    @Named("playerList")
    private List<PlayerModel> playerList;
    
    
    /*
     * Creates a new instance of StaffBean
     * 
     * init will initialize the Generic DAO as one of it's implementations in order
     * populate the object list.
     */
    public PlayerController() {
    }
    
    @PostConstruct
    public void init() {
        
        try {
        	
			playerDao = new PlayerDao();
		} 
        catch (InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
		}
        
        playerList = playerDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        playerDao.insert(currentPlayer);
        //CommonOperations.message(currentPlayer.getCharacter() + " was added successfully!");
        currentPlayer = new PlayerModel();
    }

    @Override
    public void editRecord(PlayerModel player) {
        
        currentPlayer = player;
    }

    @Override
    public void updateRecord() {
        
        playerDao.update(currentPlayer);
        init();
    }

    @Override
    public void deleteRecord(PlayerModel player) {
        
        playerDao.delete( player );
        playerList.remove( player );
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */   
    public PlayerModel getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(PlayerModel currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
 
    
    public List<PlayerModel> getPlayerList() {
        return playerList;
    }
    public void setPlayerList(List<PlayerModel> playerList) {
        this.playerList = playerList;
    }

}
