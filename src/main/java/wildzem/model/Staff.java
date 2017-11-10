package wildzem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Caio
 * @version 0.1
 * 
 * Entity/model for Staff members
 */
@Entity
@Table(name="tb_staff")
@NamedQuery(name = "Staff.validate",
            query= "SELECT s from Staff s WHERE s.user = :user AND s.password = :password")
public class Staff implements Serializable { 
    private static final long serialVersionUID = 1L;
  
    @Id
    @Column(name="ST_USERID")
    private int id;
    
    @Column(name="ST_USER")
    private String user;
    
    @Column(name="ST_PASSWORD")
    private String password;
    
    @Column(name="ST_NAME")
    private String name;
    
    @Column(name="ST_EMAIL")
    private String email;
    
    @Column(name="ST_STATUS")
    private String status;
    
    @Column(name="ST_POSITION")
    private String staffPosition;
    
    @Column(name="ST_SERVER")
    private String server;

    //////////////////

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getStaffPosition() {
        return staffPosition;
    }
    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    
    public String getServer() {
        return server;
    }
    public void setServer(String server) {
        this.server = server;
    }
}
