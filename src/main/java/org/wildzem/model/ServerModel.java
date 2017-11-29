package org.wildzem.model;


import java.io.Serializable;

import javax.enterprise.inject.Model;


/**
 * The model class for Server
 * 
 */
@Model
public class ServerModel implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 7271341697236796820L;
	
	
	/*
	 * Attributes section
	 */
	private byte serverId;
	private String code;
	private String location;
	private String status;
	
	
	/*
	 * Getter / Setter section
	 */
	public byte getServerId() {
		return serverId;
	}
	public void setServerId(byte serverId) {
		this.serverId = serverId;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	/*
	 * hashCode / Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + serverId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ServerModel other = (ServerModel) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (serverId != other.serverId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}