package wildzem.persistence;

import wildzem.model.StaffPosition;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Implementation of GenericDAO
 * 
 * T = StaffPosition
 * K = String
 * 
 */
public class StaffPositionDAO extends GenericDAO<StaffPosition, String> {

    public StaffPositionDAO() {
        super(StaffPosition.class);
    }
}
