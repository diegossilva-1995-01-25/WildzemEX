/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.persistence;

import javax.persistence.Query;
import wildzem.model.Staff;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 */
public class StaffDAO extends GenericDAO<Staff, Integer> {

    public StaffDAO() {
        super(Staff.class);
    }
    
    public Staff validateLogin(Staff staff) {
             
        try {
            
            Query query = CommonOperations.getManagerInstance().createNamedQuery("Staff.validate");          
            
            query.setParameter("user", staff.getUser());
            query.setParameter("password", staff.getPassword());
            
            Staff s = (Staff) query.getSingleResult();
            
            return s;
            
        }
        catch (Exception e) {

            return null;
        }
    }
}
