package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_position database table.
 * 
 */
@Entity
@Table(name="tb_position")
@NamedQuery(name="PositionEntity.findAll", query="SELECT p FROM PositionEntity p")
public class PositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ps_position_id", unique=true, nullable=false)
	private byte positionId;

	@Column(name="ps_access_level")
	private byte accessLevel;

	@Column(name="ps_code", columnDefinition = "CHAR",length=2)
	private String code;

	@Column(name="ps_description", length=100)
	private String description;

	@Column(name="ps_name", length=15)
	private String name;

	public PositionEntity() {
	}

	public byte getPositionId() {
		return this.positionId;
	}

	public void setPositionId(byte positionId) {
		this.positionId = positionId;
	}

	public byte getAccessLevel() {
		return this.accessLevel;
	}

	public void setAccessLevel(byte accessLevel) {
		this.accessLevel = accessLevel;
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