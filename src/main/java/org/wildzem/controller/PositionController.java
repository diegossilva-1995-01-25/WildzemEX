/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wildzem.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.wildzem.model.PositionModel;
import org.wildzem.persistence.access.PositionDao;
import org.wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 */
@ViewScoped
@Named(value="positionController")
public class PositionController implements Serializable, AbstractController<PositionModel> {
    
    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = -6652202948011843323L;
	
	
	/*
	 * Attributes section
	 */
	@Inject private PositionModel currentPosition;
    private PositionDao positionDao;
    
    @Produces 
    @Named("positionList")
    private List<PositionModel> positionList;
    
    
    /*
     * Creates a new instance of StaffController
     * 
     * init will initialize the Generic DAO as one of it's implementations in order
     * populate the object list.
     */
    public PositionController() {
    }
    
    @PostConstruct
    public void init() {
        
        try {
        	
			positionDao = new PositionDao();
		} 
        catch (InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
		}
        
        positionList = positionDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        positionDao.insert(currentPosition);
        CommonOperations.message(currentPosition.getName() + " was added successfully!");
        currentPosition = new PositionModel();
    }

    @Override
    public void editRecord(PositionModel position) {
        
        currentPosition = position;
    }

    @Override
    public void updateRecord() {
        
        positionDao.update(currentPosition);
        init();
    }

    @Override
    public void deleteRecord(PositionModel position) {
        
        positionDao.delete( position );
        positionList.remove( position );
    }
    
    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */ 
    public PositionModel getStaffPosition() {
        return currentPosition;
    }
    public void setStaffPosition(PositionModel position) {
        this.currentPosition = position;
    }

    
    public List<PositionModel> getPositionList() {
        return positionList;
    }
    public void setPositionList(List<PositionModel> positionList) {
        this.positionList = positionList;
    }
    
}
