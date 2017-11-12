package wildzem.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import wildzem.model.converter.StaffPositionConverter;

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

    @Id
    @Column(name="ST_USERID", columnDefinition = "INT", length = 5)
    private int id;
    
    @Column(name="ST_USER", columnDefinition = "VARCHAR", length = 15)
    private String user;
    
    @Column(name="ST_PASSWORD", columnDefinition = "VARCHAR", length = 20)
    private String password;
    
    @Column(name="ST_NAME", columnDefinition = "VARCHAR", length = 10)
    private String name;
    
    @Column(name="ST_EMAIL", columnDefinition = "VARCHAR", length = 30)
    private String email;
    
    @Column(name="ST_STATUS", columnDefinition = "VARCHAR", length = 10)
    private String status;
    
    //@Column(name="ST_POSITION")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ST_POSITION", nullable = false)
    private StaffPosition staffPosition;
    
    //@Column(name="ST_SERVER")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ST_SERVER", nullable = false)
    private Server server;

    /*
     * Getter/Setter section
     */
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
  
    public StaffPosition getStaffPosition() {
        return staffPosition;
    }
    public void setStaffPosition(StaffPosition staffPosition) {
        this.staffPosition = staffPosition;
    }
  
    public Server getServer() {
        return server;
    }
    public void setServer(Server server) {
        this.server = server;
    }
}
