/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.controller.filters;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * This filter will take care of the EntityManager 
 * every time a request is made to the Faces Servlet
 */
@WebFilter(servletNames = { "Faces Servlet" })
public class JPAFilter implements Filter {
    
    private EntityManagerFactory factory;
    private final String PERSISTENCE_UNIT = "Wildzem";
    
    public JPAFilter() {}    

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     * 
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
                                                                throws IOException, ServletException {
        
        /* Creates entity manager */
        EntityManager manager = this.factory.createEntityManager();
        
        /* Adding it to a request */
        request.setAttribute("entityManager", manager);
        manager.getTransaction().begin();
        
        /* Starting faces servlet */
        chain.doFilter(request, response);
        
        try {
            
            manager.getTransaction().commit();
        }
        catch (Exception e) {
            
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
        finally {
            
            manager.close();
        }
    }

    /**
     * Destroy method for this filter
     * 
     * Closes the EntityManagerFactory
     */
    public void destroy() {
        this.factory.close();
    }

    /**
     * Init method for this filter
     * 
     * Creates an instance of the EntityManagerFactory
     */
    public void init(FilterConfig filterConfig) {        

        this.factory = Persistence.createEntityManagerFactory(this.PERSISTENCE_UNIT);
    }  
}
