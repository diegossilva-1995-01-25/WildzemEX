package wildzem.model;

import java.io.Serializable;

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
    @Column(name="SV_CODE", columnDefinition = "CHAR", length = 2)
    private String code;

    @Column(name="SV_LOCATION", columnDefinition = "VARCHAR", length = 15)
    private String location;
    
    @Column(name="SV_STATUS", columnDefinition = "VARCHAR", length = 10)
    private String status;
	
    /*
     * Getter/Setter section
     */
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

    public Server() {
    }
}
