/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.persistence;

import wildzem.model.StaffPosition;

/**
 *
 * @author Caio
 */
public class StaffPositionDAO extends GenericDAO<StaffPosition, String> {

    public StaffPositionDAO() {
        super(StaffPosition.class);
    }
}
