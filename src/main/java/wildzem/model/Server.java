package wildzem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_server")
public class Server implements Serializable {
    private static final long serialVersionUID = 4453506133583341569L;
	
    @Id
    @Column(name="SV_CODE")
    private String code;
	
    @Column(name="SV_LOCATION")
    private String location;
	
    @Column(name="SV_STATUS")
    private String status;
	
    //////////////////
	
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
}
