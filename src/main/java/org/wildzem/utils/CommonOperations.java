package org.wildzem.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;


/**
 * @author Caio
 * 
 * This method is used to perform common tasks other methods would 
 * 
 */
public class CommonOperations {
    
	
    public static EntityManager getManagerInstance() {
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();
 
        return (EntityManager)request.getAttribute("entityManager");
    }
    
    
    /* 
     * Method for common messages
     */
    public static void message(String mensagem){
	
        FacesContext facesContext = FacesContext.getCurrentInstance();
	
        facesContext.addMessage(null, new FacesMessage("Attention: ",mensagem));
    }
	
    
    /*
     * Method for warning messages
     */
    public static void messageWarning(String mensagem){
	
        FacesContext facesContext = FacesContext.getCurrentInstance();
	
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning:", mensagem));
    }
	 
    
    /*
     * Method for information messages
     */
    public static void messageInformation(String mensagem){
	
        FacesContext facesContext = FacesContext.getCurrentInstance();
	
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
    }
    
}