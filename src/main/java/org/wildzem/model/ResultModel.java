package org.wildzem.model;

import java.io.Serializable;

import javax.enterprise.inject.Model;


/**
 * The model class for Result
 * 
 */
@Model
public class ResultModel implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 4284406826768077700L;
	
	
	/*
	 * Attribute section
	 */
	private int resultId;
	private String prize;
	private String status;
	private EventModel event;
	private CharacterModel character;
	
	
	/*
	 * Getter/Setter section
	 */
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	
	
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public EventModel getEvent() {
		return event;
	}
	public void setEvent(EventModel event) {
		this.event = event;
	}
	
	
	public CharacterModel getCharacter() {
		return character;
	}
	public void setCharacter(CharacterModel character) {
		this.character = character;
	}
	
	
	/*
	 * HashCode / Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((prize == null) ? 0 : prize.hashCode());
		result = prime * result + resultId;
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
		ResultModel other = (ResultModel) obj;
		if (character == null) {
			if (other.character != null)
				return false;
		} else if (!character.equals(other.character))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (prize == null) {
			if (other.prize != null)
				return false;
		} else if (!prize.equals(other.prize))
			return false;
		if (resultId != other.resultId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}