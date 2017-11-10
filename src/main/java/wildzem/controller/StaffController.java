package wildzem.controller;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import wildzem.model.Staff;
import wildzem.persistence.StaffDAO;

/**
 *
 * @author Caio
 */

@ViewScoped
@Named(value="staffController")
public class StaffController extends GenericController<Staff, Integer, StaffDAO> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public StaffController() {
        super(Staff.class, StaffDAO.class);
    }
}