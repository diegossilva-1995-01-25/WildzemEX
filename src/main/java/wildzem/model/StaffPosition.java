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
 * Entity/model for Staff members
 */
@Entity
@Table(name="tb_staff_position")
public class StaffPosition implements Serializable {

    
    @Id
    @Column(name="SP_CODE", columnDefinition = "CHAR", length = 2)
    private String code;

    @Column(name="SP_POSITION", columnDefinition = "VARCHAR", length = 15)
    private String position;

    @Column(name="SP_ACCESS_LEVEL", columnDefinition = "TINYINT", length = 1)
    private byte accessLevel;
    
    @Column(name="SP_DESCRIPTION", columnDefinition = "VARCHAR", length = 50)
    private String description;

    /*
     * Getter/Setter section
     */
    public String getCode() {
        return code;
    }	
    public void setCode(String code) {
        this.code = code;
    }

    public String getPosition() {
        return position;
    }	
    public void setPosition(String position) {
        this.position = position;
    }

    public byte getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(byte accessLevel) {
        this.accessLevel = accessLevel;
    }
      	    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
