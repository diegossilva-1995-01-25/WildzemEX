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
    
    /*
     * Equals/Hash Code section
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.code);
        hash = 13 * hash + Objects.hashCode(this.position);
        hash = 13 * hash + this.accessLevel;
        hash = 13 * hash + Objects.hashCode(this.description);
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
        
        final StaffPosition other = (StaffPosition) obj;
        
        System.out.println( this.code.equals( other.getCode() ) );
        System.out.println( other.getCode() + " vs " + this.code );
        System.out.println( other.getPosition() + " vs " + this.position );
        System.out.println( other.getAccessLevel()+ " vs " + this.accessLevel );
        
        if ( !this.code.equals( other.getCode() ) ) {
            
            return false;
        }
              
        return true;
    }
}
