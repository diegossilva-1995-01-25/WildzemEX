/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.persistence;

import wildzem.model.Server;

/**
 *
 * @author Caio
 */
public class ServerDAO extends GenericDAO<Server, String> {

    public ServerDAO() {
        super(Server.class);
    }
}
