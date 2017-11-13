package wildzem.persistence;

import wildzem.model.Server;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Implementation of GenericDAO
 * 
 * T = Server
 * K = String
 * 
 */
public class ServerDAO extends GenericDAO<Server, Byte> {

    public ServerDAO() {
        super(Server.class);
    }
}
