package wildzem.persistence;

import javax.persistence.Query;
import wildzem.model.Staff;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Implementation of GenericDAO
 * 
 * T = Staff
 * K = Integer
 * 
 */
public class StaffDAO extends GenericDAO<Staff, Integer> {

    public StaffDAO() {
        super(Staff.class);
    }
    
    /**
     * 
     * Verifies the login sent by the login.xhtml page by finding Staff member
     * by Username and Password.
     * 
     * @param staff: Object originated from login.xhtml
     * 
     * @return Returns the full record if the Query is positive, else it returns null
     */
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
