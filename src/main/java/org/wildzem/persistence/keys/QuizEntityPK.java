package org.wildzem.persistence.keys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_quiz database table.
 * 
 */
@Embeddable
public class QuizEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="qu_question_id", unique=true, nullable=false)
	private int questionId;

	@Column(name="qu_type_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte quTypeId;

	@Column(name="qu_staff_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte quStaffId;

	@Column(name="qu_position_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte quPositionId;

	public QuizEntityPK() {
	}
	public int getQuestionId() {
		return this.questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public byte getQuTypeId() {
		return this.quTypeId;
	}
	public void setQuTypeId(byte quTypeId) {
		this.quTypeId = quTypeId;
	}
	public byte getQuStaffId() {
		return this.quStaffId;
	}
	public void setQuStaffId(byte quStaffId) {
		this.quStaffId = quStaffId;
	}
	public byte getQuPositionId() {
		return this.quPositionId;
	}
	public void setQuPositionId(byte quPositionId) {
		this.quPositionId = quPositionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof QuizEntityPK)) {
			return false;
		}
		QuizEntityPK castOther = (QuizEntityPK)other;
		return 
			(this.questionId == castOther.questionId)
			&& (this.quTypeId == castOther.quTypeId)
			&& (this.quStaffId == castOther.quStaffId)
			&& (this.quPositionId == castOther.quPositionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.questionId;
		hash = hash * prime + ((int) this.quTypeId);
		hash = hash * prime + ((int) this.quStaffId);
		hash = hash * prime + ((int) this.quPositionId);
		
		return hash;
	}
}