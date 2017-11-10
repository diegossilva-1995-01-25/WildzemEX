/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 */
public abstract class GenericDAO<T, K extends Serializable> {
    
    protected EntityManager entityManager;
    private Class<T> persistedClass;

    protected GenericDAO() {}

    protected GenericDAO(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }
    
    //////////////////
    
    public void insert(T object){
        
        entityManager = CommonOperations.getManagerInstance();
        entityManager.persist(object);
    }
    
    public void update(T object){
        
        entityManager = CommonOperations.getManagerInstance();
        entityManager.merge(object);
    }
    
    public void delete(K key){
        
        entityManager = CommonOperations.getManagerInstance();
        T object = select(key);
        
        entityManager.remove(object);
    }
    
    public List<T> selectAll(){
        
        entityManager = CommonOperations.getManagerInstance();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        
        return entityManager.createQuery(query).getResultList();
    }
    
    public T select(K key){
        
        entityManager = CommonOperations.getManagerInstance();
        return entityManager.find(persistedClass, key);
    }   
}
