package wildzem.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import wildzem.model.Player;
import wildzem.persistence.PlayerDAO;

/**
 *
 * @author Caio
 */

@ViewScoped
@Named(value="playerController")
public class PlayerController extends GenericController<Player, Integer, PlayerDAO> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public PlayerController() {
        super(Player.class, PlayerDAO.class);
    }
}
