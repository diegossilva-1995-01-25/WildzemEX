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

import org.wildzem.model.TypeModel;
import org.wildzem.persistence.access.TypeDao;
import org.wildzem.utils.CommonOperations;


/**
 *
 * @author Caio
 */
@ViewScoped
@Named(value="quizTyoeController")
public class TypeController implements Serializable, AbstractController<TypeModel> {
    
    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = 6589682540896474915L;
	
	
	/*
	 * Attributes section
	 */
	@Inject private TypeModel currentType;
    private TypeDao typeDao;
    
    @Produces 
    @Named("typeList")
    private List<TypeModel> typeList;
    
    
    /*
     * Creates a new instance of QuizTypeController
     * 
     * init will initialize the Generic DAO as one of it's implementations in order
     * populate the object list.
     */
    public TypeController() {
    }
    
    @PostConstruct
    public void init() {
        
        try {
        	
			typeDao = new TypeDao();
		} 
        catch (InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
		}
        
        typeList = typeDao.selectAll();
    }
    
    
    /*
     * This section implements all the abstract methods from GenericController 
     */
    @Override
    public void addNew() {
        
        typeDao.insert(currentType);
        CommonOperations.message(currentType.getName() + " was added successfully!" );
        currentType = new TypeModel();
    }

    @Override
    public void editRecord(TypeModel type) {
        
        currentType = type;
    }

    @Override
    public void updateRecord() {
        
        typeDao.update(currentType);
        init();
    }

    @Override
    public void deleteRecord(TypeModel type) {
        
        typeDao.delete( type );
        typeList.remove( type );
    }

    
    /*
     * Getter and setter section to be used by JSF via managed bean
     */  
    public TypeModel getCurrentType() {
        return currentType;
    }
    public void setCurrentType(TypeModel currentType) {
        this.currentType = currentType;
    }

    public List<TypeModel> getTypeList() {
        return typeList;
    }
    public void setTypeList(List<TypeModel> typeList) {
        this.typeList = typeList;
    }
    
}
