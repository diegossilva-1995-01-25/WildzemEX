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
 * @version 1.0
 * 
 * Generic DAO to hold the methods any other DAO implementing it. Since the methods
 * are very basic there's no need to implement them in each DAO.
 * 
 * @param <T>: Type of object to be used in the implementation
 * @param <K>: Type of primary key to be used in the implementation
 */
public abstract class GenericDAO<T, K extends Serializable> {
    
    protected EntityManager entityManager;
    private Class<T> persistedClass;

    /**
     * Blank constructor
     */
    protected GenericDAO() {
    }
    
    /**
     * Constructor to initiate the generic Class T by using an actual Object.class
     * provided by the DAO implementation. This will further be used on the select method.
     * 
     * @param persistedClass: Provided by the DAO implementation.
     */
    protected GenericDAO(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
    }
    
    /**
     * Basic JPA insertion with a generic object.
     * 
     * @param object: generic object
     */
    public void insert(T object){
        
        entityManager = CommonOperations.getManagerInstance();
        entityManager.persist(object);
    }
    
    /**
     * Basic JPA update with a generic object.
     * 
     * @param object: generic object
     */
    public void update(T object){
        
        entityManager = CommonOperations.getManagerInstance();
        entityManager.merge(object);
    }
    
    /**
     * Basic JPA deletion with a generic key.
     * 
     * @param key: generic key
     */
    public void delete(K key){
        
        entityManager = CommonOperations.getManagerInstance();
        T object = select(key);
        
        entityManager.remove(object);
    }
    
    /**
     * Basic JPA select all method. This method makes use of the generic Class
     * initialized by the constructor to identify which Object it should look for
     * in the Database.
     * 
     * @return By making use of the provided class it creates a query that will 
     * return a list of T.
     */
    public List<T> selectAll(){
        
        entityManager = CommonOperations.getManagerInstance();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        
        return entityManager.createQuery(query).getResultList();
    }
    
    /**
     * Basic JPA select method. This method makes use of the generic Class
     * initialized by the constructor to identify which Object it should look for
     * in the Database.
     * 
     * @param key: Generic key object that will be looked for in the mapped tables.
     * 
     * @return Makes use of provided JPA method find to locate a record 
     * via key and returns said record.
     */
    public T select(K key){
        
        entityManager = CommonOperations.getManagerInstance();
        return entityManager.find(persistedClass, key);
    }   
}
