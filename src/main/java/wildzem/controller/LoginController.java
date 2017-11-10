/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 */

@SessionScoped
@Named(value="loginController")
public class LoginController implements Serializable {
    private static final long serialVersionUID = 8999662889144586748L;
    
    @Inject private Staff staff;
    private StaffDAO dao;
    
    /**
     * Creates a new instance of StaffBean
     */
    public LoginController() {
    }
    
    @PostConstruct
    public void init() {
        
        dao = new StaffDAO();
    }
    
    //////////////////

    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }
   
    //////////////////
    
    public Staff getStaffSession() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        return (Staff) context.getExternalContext().getSessionMap().get("authUser");
    }
    
    public String logOut() {
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String logIn() {
        
        if ( StringUtils.isEmpty( staff.getUser() ) || StringUtils.isBlank( staff.getUser() ) ) {
            
            CommonOperations.message("Username is required!");
            return null;
        }
        else if ( StringUtils.isEmpty( staff.getPassword() ) || StringUtils.isBlank( staff.getPassword() ) ) {
            
            CommonOperations.message("Password is required!");
            return null;
        }
        else {
            
            Staff s = dao.validateLogin(staff);
            
            if (s != null) {

                staff.setName(s.getName());
                staff.setUser(s.getUser());
                staff.setPassword(null);
                
                FacesContext context = FacesContext.getCurrentInstance();
                
                context.getExternalContext().getSessionMap().put("authUser", staff);
                
                return "system/home?faces-redirect=true";
            }
            else {

                CommonOperations.message("Username or password is incorrect!");
                return null;
            }
            
        } 
        
    }
    
}
