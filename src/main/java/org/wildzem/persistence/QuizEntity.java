package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;

import org.wildzem.persistence.keys.QuizEntityPK;


/**
 * The persistent class for the tb_quiz database table.
 * 
 */
@Entity
@Table(name="tb_quiz")
@NamedQuery(name="QuizEntity.findAll", query="SELECT q FROM QuizEntity q")
public class QuizEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private QuizEntityPK id;

	@Column(name="qu_answer", length=20)
	private String answer;

	@Column(name="qu_is_shared")
	private boolean shared;

	@Column(name="qu_question", length=95)
	private String question;

	@Column(name="qu_uses")
	private short uses;

	//uni-directional many-to-one association to TypeEntity
	@ManyToOne
	@JoinColumn(name="qu_type_id", nullable=false, insertable=false, updatable=false)
	private TypeEntity QuizTypeEntity;

	//uni-directional many-to-one association to StaffEntity
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="qu_position_id", referencedColumnName="st_staff_id", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="qu_staff_id", referencedColumnName="st_position_id", nullable=false, insertable=false, updatable=false)
		})
	private StaffEntity StaffEntity;

	public QuizEntity() {
	}

	public QuizEntityPK getId() {
		return this.id;
	}

	public void setId(QuizEntityPK id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isShared() {
		return this.shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public short getUses() {
		return this.uses;
	}

	public void setUses(short uses) {
		this.uses = uses;
	}

	public TypeEntity getQuizTypeEntity() {
		return this.QuizTypeEntity;
	}

	public void setQuizTypeEntity(TypeEntity QuizTypeEntity) {
		this.QuizTypeEntity = QuizTypeEntity;
	}

	public StaffEntity getStaffEntity() {
		return this.StaffEntity;
	}

	public void setStaffEntity(StaffEntity StaffEntity) {
		this.StaffEntity = StaffEntity;
	}

}