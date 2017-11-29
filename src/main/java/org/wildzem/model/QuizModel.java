package org.wildzem.model;


import java.io.Serializable;

import javax.enterprise.inject.Model;


/**
 * The model class for Character
 * 
 */
@Model
public class QuizModel implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -4572682367042517506L;
	
	
	/*
	 * Attribute section
	 */
	private int questionId;
	private String question;
	private String answer;
	private short uses;
	private boolean shared;
	private TypeModel type;
	private StaffModel staff;
	
	
	/*
	 * Getter/Setter section
	 */
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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
	
	
	public short getUses() {
		return uses;
	}
	public void setUses(short uses) {
		this.uses = uses;
	}
	
	
	public boolean isShared() {
		return shared;
	}
	public void setShared(boolean shared) {
		this.shared = shared;
	}
	
	
	public TypeModel getType() {
		return type;
	}
	public void setType(TypeModel type) {
		this.type = type;
	}
	
	
	public StaffModel getStaff() {
		return staff;
	}
	public void setStaff(StaffModel staff) {
		this.staff = staff;
	}
	
	
	/*
	 * HashCode / Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + questionId;
		result = prime * result + (shared ? 1231 : 1237);
		result = prime * result + ((staff == null) ? 0 : staff.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + uses;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizModel other = (QuizModel) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questionId != other.questionId)
			return false;
		if (shared != other.shared)
			return false;
		if (staff == null) {
			if (other.staff != null)
				return false;
		} else if (!staff.equals(other.staff))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uses != other.uses)
			return false;
		return true;
	}	
	
}