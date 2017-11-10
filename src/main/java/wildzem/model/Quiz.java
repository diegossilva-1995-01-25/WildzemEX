package wildzem.model;

import java.io.Serializable;

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
}
