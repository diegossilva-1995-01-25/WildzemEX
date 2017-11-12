package wildzem.model;

import java.io.Serializable;
import java.util.Objects;

public class Quiz implements Serializable {
	private static final long serialVersionUID = 9185898374554903975L;
	
	private short id;
	private String question;
	private String answer;
	private int uses;
	private boolean isShared;
	private QuizCategory quizCategory;
	private Staff staff;
	
	
	public short getId() {
		return id;
	}
	
	public void setId(short id) {
		this.id = id;
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
	
	public boolean isShared() {
		return isShared;
	}
	
	public void setShared(boolean isShared) {
		this.isShared = isShared;
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
      
    /*
     * Equals/Hash Code section
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.question);
        hash = 19 * hash + Objects.hashCode(this.answer);
        hash = 19 * hash + this.uses;
        hash = 19 * hash + (this.isShared ? 1 : 0);
        hash = 19 * hash + Objects.hashCode(this.quizCategory);
        hash = 19 * hash + Objects.hashCode(this.staff);
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
