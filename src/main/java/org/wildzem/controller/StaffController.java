package org.wildzem.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.wildzem.model.PositionModel;
import org.wildzem.model.StaffModel;
import org.wildzem.persistence.access.StaffDao;
import org.wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 * @version 0.5
 */
@ViewScoped
@Named(value="staffController")
public class StaffController implements Serializable, AbstractController<StaffModel> {
     
    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = -5888447361651000633L;
	
	
	/*
	 * Attributes section
	 */
	@Inject private StaffModel currentStaff;
    @Inject private List<PositionModel> positionList;
    private StaffDao staffDao;
    
    @Produces private List<StaffModel> staffList;

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

        try {
			
        	staffDao = new StaffDao();
		} 
        catch (InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
        
        staffList = staffDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        staffDao.insert(currentStaff);
        CommonOperations.message(currentStaff.getName() + " was added successfully!");
        currentStaff = new StaffModel();
    }

    @Override
    public void editRecord(StaffModel staff) {
        
        currentStaff = staff;
    }

    @Override
    public void updateRecord() {
        
        staffDao.update(currentStaff);
        init();
    }

    @Override
    public void deleteRecord(StaffModel staff) {
        
        staffDao.delete( staff );
        staffList.remove( staff );
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */  
    public StaffModel getCurrentStaff() {
        return currentStaff;
    }
    public void setCurrentStaff(StaffModel currentStaff) {
        this.currentStaff = currentStaff;
    }
    
    public List<StaffModel> getStaffList() {
        return staffList;
    }
    public void setStaffList(List<StaffModel> staffList) {
        this.staffList = staffList;
    } 

    public List<PositionModel> getPositionList() {
        return positionList;
    }
    public void setPositionList(List<PositionModel> positionList) {
        this.positionList = positionList;
    } 
    
}