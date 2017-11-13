package wildzem.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_quiz_category")
public class QuizCategory implements Serializable {
    private static final long serialVersionUID = -2765108833083445088L;
	
    @Id
    @Column(name="QC_CATEGORYID", columnDefinition = "TINYINT")
    private byte id;
    
    @Column(name = "QC_CODE")
    private String code;
    
    @Column(name = "QC_NAME")
    private String name;
    
    @Column(name = "QC_DESCRIPTION")
    private String description;
	
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.code);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.description);
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
        final QuizCategory other = (QuizCategory) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
   
}
