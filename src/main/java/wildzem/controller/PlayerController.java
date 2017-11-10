package wildzem.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wildzem.model.Player;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.PlayerDAO;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 * @version 0.5
 */

@ViewScoped
@Named(value="playerController")
public class PlayerController implements Serializable, GenericController<Player> {
    private static final long serialVersionUID = 1L;
    
    
    @Inject private Player currentPlayer;
    @Inject private GenericDAO<Player, Integer> playerDao;
    
    @Produces private List<Player> playerList;
    
    
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
        
        playerDao = new PlayerDAO();
        playerList = playerDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        playerDao.insert(currentPlayer);
        CommonOperations.message(currentPlayer.getCharacter() + " was added successfully!");
        currentPlayer = new Player();
    }

    @Override
    public void editRecord(Player player) {
        
        currentPlayer = player;
    }

    @Override
    public void updateRecord() {
        
        playerDao.update(currentPlayer);
        init();
    }

    @Override
    public void deleteRecord(Player player) {
        
        playerDao.delete( player.getId() );
        playerList.remove(player);
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */   
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    
    public List<Player> getPlayerList() {
        return playerList;
    }
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
