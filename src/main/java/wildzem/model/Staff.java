package wildzem.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Id
    @Column(name="ST_USERID", columnDefinition = "MEDIUMINT", length = 5)
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ST_POSITION", nullable = false, referencedColumnName = "SP_POSITIONID")
    private StaffPosition staffPosition;
    
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
    
    /*
     * Equals/Hash Code section
     */

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.user);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.status);
        hash = 47 * hash + Objects.hashCode(this.staffPosition);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Staff other = (Staff) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.staffPosition, other.staffPosition)) {
            return false;
        }
        return true;
    }
}
