package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_quiz_type database table.
 * 
 */
@Entity
@Table(name="tb_quiz_type")
@NamedQuery(name="TypeEntity.findAll", query="SELECT t FROM TypeEntity t")
public class TypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="qt_type_id", unique=true, nullable=false)
	private byte typeId;

	@Column(name="qt_code", columnDefinition = "CHAR", length=3)
	private String code;

	@Column(name="qt_description", length=100)
	private String description;

	@Column(name="qt_name", length=20)
	private String name;

	public TypeEntity() {
	}

	public byte getTypeId() {
		return this.typeId;
	}

	public void setTypeId(byte typeId) {
		this.typeId = typeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}