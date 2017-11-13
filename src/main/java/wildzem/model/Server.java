package wildzem.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Caio
 * @version 0.1
 * 
 * Entity/model for Server members
 */
@Entity
@Table(name="tb_server")
public class Server implements Serializable {

    @Id
    @Column(name="SV_SERVERID", columnDefinition = "TINYINT")
    private byte id;
    
    @Column(name="SV_CODE", columnDefinition = "CHAR", length = 2)
    private String code;

    @Column(name="SV_LOCATION")
    private String location;
    
    @Column(name="SV_STATUS")
    private String status;
	
    /*
     * Getter/Setter section
     */
    public byte getId() {
        return id;
    }
    public void setId(byte id) {
        this.id = id;
    } 
    
    public String getCode() {
        return code;
    }	
    public void setCode(String code) {
        this.code = code;
    }
	
    public String getLocation() {
        return location;
    }	
    public void setLocation(String location) {
        this.location = location;
    }
	
    public String getStatus() {
        return status;
    }	
    public void setStatus(String status) {
        this.status = status;
    }
    
    /*
     * Equals/Hash Code section
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.code);
        hash = 29 * hash + Objects.hashCode(this.location);
        hash = 29 * hash + Objects.hashCode(this.status);
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
        
        final Server other = (Server) obj;
        
        if ( !this.code.equals( other.getCode() ) ) {
            
            return false;
        }
        
        return true;
    }

    
}
