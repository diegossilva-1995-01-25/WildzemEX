/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.persistence;

import wildzem.model.Player;

/**
 *
 * @author Caio
 */
public class PlayerDAO extends GenericDAO<Player, Integer> {

    public PlayerDAO() {
        super(Player.class);
    } 
}
