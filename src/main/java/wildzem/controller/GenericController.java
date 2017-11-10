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
import wildzem.persistence.GenericDAO;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 */

public abstract class GenericController<T, K extends Serializable, P> {

    private Class<T> objectClass;
    private Class<P> daoClass;

    protected T object;
    protected GenericDAO<T, K> dao;
    
    @Produces protected List<T> list;
    
    //////////////////
    
    protected GenericController() {}
    
    protected GenericController(Class<T> objectClass, Class<P> daoClass) {
        this();
        this.objectClass = objectClass;
        this.daoClass = daoClass;
    }
    
    @PostConstruct
    public void init() {        
        
        try {
            object = objectClass.newInstance();
            dao = (GenericDAO<T, K>) daoClass.newInstance();
        } 
        catch (InstantiationException | IllegalAccessException ex) {
            
            ex.printStackTrace();
        }
        
        list = dao.selectAll();
    }
    
    ////////////////// 

    public T getObject() {
        return object;
    }
    public void setObject(T object) {
        this.object = object;
    }

    
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }
     
    //////////////////  
    
    public void insert() {
        
        dao.insert(object);
        CommonOperations.message("Record was added successfully!");
        try {
            
            object = objectClass.newInstance();
        } 
        catch (InstantiationException | IllegalAccessException ex) {
            
            ex.printStackTrace();
        }
    }
    
    public void editStaff(T object) {
        this.object = object;
    }
    
    public void update() {
        
        dao.update(object);
        this.init();
    }
    
    public void delete(K key) {
        
        dao.delete(key);
        
        list = dao.selectAll();
    }
}
