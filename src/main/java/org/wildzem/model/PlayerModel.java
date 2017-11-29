package org.wildzem.model;


import java.io.Serializable;

import javax.enterprise.inject.Model;


/**
 * The model class for Player
 * 
 */
@Model
public class PlayerModel implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1004244783964490540L;
	
	
	/*
	 * Attribute section
	 */
	private int playerId;
	private String inGameLogin;
	private String status;
	private short winCount;
	
	
	/*
	 * Getter/Setter section
	 */
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
	public String getInGameLogin() {
		return inGameLogin;
	}
	public void setInGameLogin(String inGameLogin) {
		this.inGameLogin = inGameLogin;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public short getWinCount() {
		return winCount;
	}
	public void setWinCount(short winCount) {
		this.winCount = winCount;
	}
	

	/*
	 * HashCode / Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inGameLogin == null) ? 0 : inGameLogin.hashCode());
		result = prime * result + playerId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + winCount;
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
		PlayerModel other = (PlayerModel) obj;
		if (inGameLogin == null) {
			if (other.inGameLogin != null)
				return false;
		} else if (!inGameLogin.equals(other.inGameLogin))
			return false;
		if (playerId != other.playerId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (winCount != other.winCount)
			return false;
		return true;
	}
	
}