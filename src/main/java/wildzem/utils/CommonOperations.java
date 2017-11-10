/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildzem.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Caio
 */
public class CommonOperations {
    
    public static EntityManager getManagerInstance() {
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request  = (HttpServletRequest)externalContext.getRequest();
 
        return (EntityManager)request.getAttribute("entityManager");
    }
    
    // Method for messages
    public static void message(String mensagem){
	
        FacesContext facesContext = FacesContext.getCurrentInstance();
	
        facesContext.addMessage(null, new FacesMessage("Attention: ",mensagem));
    }
	
    // Method for messages
    public static void messageAtt(String mensagem){
	
        FacesContext facesContext = FacesContext.getCurrentInstance();
	
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning:", mensagem));
    }
	 
    // Method for messages
    public static void messageAlert(String mensagem){
	
        FacesContext facesContext = FacesContext.getCurrentInstance();
	
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
    }
}