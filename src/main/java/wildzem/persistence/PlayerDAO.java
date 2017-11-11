package wildzem.persistence;

import wildzem.model.Player;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Implementation of GenericDAO
 * 
 * T = Player
 * K = Integer
 * 
 */
public class PlayerDAO extends GenericDAO<Player, Integer> {

    public PlayerDAO() {
        super(Player.class);
    } 
}
