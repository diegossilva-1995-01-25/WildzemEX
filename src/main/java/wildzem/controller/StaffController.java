package wildzem.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wildzem.model.Server;
import wildzem.model.Staff;
import wildzem.model.StaffPosition;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.StaffDAO;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 * @version 0.5
 */
@ViewScoped
@Named(value="staffController")
public class StaffController implements Serializable, GenericController<Staff> {
    private static final long serialVersionUID = 1L;
    
    
    @Inject private Staff currentStaff;
    @Inject private List<StaffPosition> positionList;
    private GenericDAO<Staff, Integer> staffDao;
    
    @Produces private List<Staff> staffList;

    /*
     * Creates a new instance of StaffController
     * 
     * init will initialize the Generic DAO as one of it's implementations in order
     * populate the object list.
     */
    public StaffController() {
    }
    
    @PostConstruct
    public void init() {

        staffDao = new StaffDAO();
        staffList = staffDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        staffDao.insert(currentStaff);
        CommonOperations.message(currentStaff.getName() + " was added successfully!");
        currentStaff = new Staff();
    }

    @Override
    public void editRecord(Staff staff) {
        
        currentStaff = staff;
    }

    @Override
    public void updateRecord() {
        
        staffDao.update(currentStaff);
        init();
    }

    @Override
    public void deleteRecord(Staff staff) {
        
        staffDao.delete( staff.getId() );
        staffList.remove(staff);
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */  
    public Staff getCurrentStaff() {
        return currentStaff;
    }
    public void setCurrentStaff(Staff currentStaff) {
        this.currentStaff = currentStaff;
    }
    
    public List<Staff> getStaffList() {
        return staffList;
    }
    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    } 

    public List<StaffPosition> getPositionList() {
        return positionList;
    }
    public void setPositionList(List<StaffPosition> positionList) {
        this.positionList = positionList;
    } 
    
}