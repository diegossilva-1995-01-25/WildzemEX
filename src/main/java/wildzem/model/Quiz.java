package wildzem.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_quiz")
public class Quiz implements Serializable {
    private static final long serialVersionUID = 9185898374554903975L;

    @Id
    @Column(name="QU_ID")
    private short id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QC_CATEGORY", nullable = false, referencedColumnName = "QC_CATEGORYID")
    private QuizCategory quizCategory;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns( {
        @JoinColumn(name = "QC_OWNER", nullable = false, referencedColumnName = "ST_USERID"),
        @JoinColumn(name = "QC_OWNER_POSITION", nullable = false, referencedColumnName = "ST_POSITION")
    } )
    private Staff staff;
    
    @Column(name="QU_QUESTION")
    private String question;
    
    @Column(name="QU_ANSWER")
    private String answer;
    
    @Column(name="QU_USES")
    private int uses;
    
    @Column(name="QU_IS_SHARED")
    private boolean isShared;
  
    /*
     * Getter/Setter section
     */
    public short getId() {
        return id;
    }
    public void setId(short id) {
        this.id = id;
    }

    public QuizCategory getQuizCategory() {
        return quizCategory;
    }
    public void setQuizCategory(QuizCategory quizCategory) {
        this.quizCategory = quizCategory;
    }

    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getUses() {
        return uses;
    }
    public void setUses(int uses) {
        this.uses = uses;
    }

    public boolean isIsShared() {
        return isShared;
    }
    public void setIsShared(boolean isShared) {
        this.isShared = isShared;
    }
   
    /*
     * Equals/Hash Code section
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.quizCategory);
        hash = 59 * hash + Objects.hashCode(this.staff);
        hash = 59 * hash + Objects.hashCode(this.question);
        hash = 59 * hash + Objects.hashCode(this.answer);
        hash = 59 * hash + this.uses;
        hash = 59 * hash + (this.isShared ? 1 : 0);
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
        final Quiz other = (Quiz) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.uses != other.uses) {
            return false;
        }
        if (this.isShared != other.isShared) {
            return false;
        }
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        if (!Objects.equals(this.quizCategory, other.quizCategory)) {
            return false;
        }
        if (!Objects.equals(this.staff, other.staff)) {
            return false;
        }
        return true;
    }
    
}
