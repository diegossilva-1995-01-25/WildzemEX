package org.wildzem.model;

import java.io.Serializable;

import javax.enterprise.inject.Model;


/**
 * The model class for Position
 * 
 */
@Model
public class PositionModel implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -7185564716915732054L;
	
	
	/*
	 * Attribute section
	 */
	private byte positionId;
	private byte accessLevel;
	private String code;
	private String description;
	private String name;
	
	
	/*
	 * Getter/Setter section
	 */
	public byte getPositionId() {
		return positionId;
	}
	public void setPositionId(byte positionId) {
		this.positionId = positionId;
	}
	
	
	public byte getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(byte accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	/*
	 * HashCode / Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accessLevel;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + positionId;
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
		PositionModel other = (PositionModel) obj;
		if (accessLevel != other.accessLevel)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (positionId != other.positionId)
			return false;
		return true;
	}	
	
}