/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import wildzem.model.StaffPosition;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.StaffPositionDAO;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 */
@ViewScoped
@Named(value="staffPositionController")
public class StaffPositionController implements Serializable, GenericController<StaffPosition> {
    private static final long serialVersionUID = 1L;
    
    @Inject private StaffPosition currentStaffPosition;
    private GenericDAO<StaffPosition, String> staffPositionDao;
    
    @Produces 
    @Named("positionList")
    private List<StaffPosition> staffPositionList;
    
    /*
     * Creates a new instance of StaffController
     * 
     * init will initialize the Generic DAO as one of it's implementations in order
     * populate the object list.
     */
    public StaffPositionController() {
    }
    
    @PostConstruct
    public void init() {
        
        staffPositionDao = new StaffPositionDAO();
        staffPositionList = staffPositionDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        staffPositionDao.insert(currentStaffPosition);
        CommonOperations.message(currentStaffPosition.getPosition()+ " was added successfully!");
        currentStaffPosition = new StaffPosition();
    }

    @Override
    public void editRecord(StaffPosition staffPosition) {
        
    }

    @Override
    public void updateRecord() {
        
        staffPositionDao.update(currentStaffPosition);
        init();
    }

    @Override
    public void deleteRecord(StaffPosition staffPosition) {
        
        staffPositionDao.delete(staffPosition.getCode());
        staffPositionList.remove(staffPosition);
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */ 
    public StaffPosition getStaffPosition() {
        return currentStaffPosition;
    }
    public void setStaffPosition(StaffPosition staffPosition) {
        this.currentStaffPosition = staffPosition;
    }

    public List<StaffPosition> getStaffPositionList() {
        return staffPositionList;
    }
    public void setStaffPositionList(List<StaffPosition> staffPositionList) {
        this.staffPositionList = staffPositionList;
    }
    
}
