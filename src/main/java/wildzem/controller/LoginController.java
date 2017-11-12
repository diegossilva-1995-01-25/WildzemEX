package wildzem.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import wildzem.model.Staff;
import wildzem.persistence.StaffDAO;
import wildzem.utils.CommonOperations;

/**
 *
 * @author Caio
 * @version 0.5
 * 
 * Managed bean. It's only function is to control login sessions in the system;
 * 
 */
@SessionScoped
@Named(value="loginController")
public class LoginController implements Serializable {
    private static final long serialVersionUID = 8999662889144586748L;
    
    @Inject private Staff staff;
    private Staff sessionStaff;
    private StaffDAO dao;
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    /**
     * After creating the instance this method is called to make an instance of the DAO
     */
    @PostConstruct
    public void init() {
        
        dao = new StaffDAO();
    }
      
    /**
     * Method to return to index.xhtml when inside the system
     * 
     * @return String redirecting to index.xhtml
     */
    public String logOut() {
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/index.xhtml?faces-redirect=true";
    }
      
    /**
     * Validation method to grant access to the system.
     * 
     * @return String redirecting to home.xhtml
     */
    public String logIn() {
        
        if ( StringUtils.isEmpty( staff.getUser() ) || StringUtils.isBlank( staff.getUser() ) ) {
            
            // If the login is empty or blank throw message and do nothing       
            CommonOperations.message("Username is required!");
            
            return null;
        }
        else if ( StringUtils.isEmpty( staff.getPassword() ) || StringUtils.isBlank( staff.getPassword() ) ) {
            
            // If the password is empty or blank throw message and do nothing      
            CommonOperations.message("Password is required!");
            
            return null;
        }
        else {
            
            // Using the dao to select the user if it exists.   
            sessionStaff = dao.validateLogin(staff);
            
            if (sessionStaff != null) {
                
                /* 
                 * If the user exists set pass to null and add it to the session scope
                 * Then redirect to home
                 */
                staff = new Staff();
                
                FacesContext context = FacesContext.getCurrentInstance();
                
                context.getExternalContext().getSessionMap().put("authUser", sessionStaff);
                
                return "system/home?faces-redirect=true";
            }
            else {
                
                /* 
                 * Else throw message and do nothing
                 */
                CommonOperations.message("Username or password is incorrect!");
                return null;
            }
            
        } 
        
    }
    
    /*
     * Getter and setter section
     */
    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
    
    /**
     * This method is used to get a user already in a session
     * 
     * @return Staff in session
     */
    public Staff getStaffSession() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        return (Staff) context.getExternalContext().getSessionMap().get("authUser");
    }
}
