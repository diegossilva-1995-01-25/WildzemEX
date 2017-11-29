package org.wildzem.persistence.keys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_winner_list database table.
 * 
 */
@Embeddable
public class ResultEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="wn_winner_id", unique=true, nullable=false)
	private int winnerId;

	@Column(name="wn_event_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int wnEventId;

	@Column(name="wn_staff_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte wnStaffId;

	@Column(name="wn_position_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte wnPositionId;

	@Column(name="wn_character_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int wnCharacterId;

	@Column(name="wn_server_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte wnServerId;

	@Column(name="wn_player_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int wnPlayerId;

	public ResultEntityPK() {
	}
	public int getWinnerId() {
		return this.winnerId;
	}
	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}
	public int getWnEventId() {
		return this.wnEventId;
	}
	public void setWnEventId(int wnEventId) {
		this.wnEventId = wnEventId;
	}
	public byte getWnStaffId() {
		return this.wnStaffId;
	}
	public void setWnStaffId(byte wnStaffId) {
		this.wnStaffId = wnStaffId;
	}
	public byte getWnPositionId() {
		return this.wnPositionId;
	}
	public void setWnPositionId(byte wnPositionId) {
		this.wnPositionId = wnPositionId;
	}
	public int getWnCharacterId() {
		return this.wnCharacterId;
	}
	public void setWnCharacterId(int wnCharacterId) {
		this.wnCharacterId = wnCharacterId;
	}
	public byte getWnServerId() {
		return this.wnServerId;
	}
	public void setWnServerId(byte wnServerId) {
		this.wnServerId = wnServerId;
	}
	public int getWnPlayerId() {
		return this.wnPlayerId;
	}
	public void setWnPlayerId(int wnPlayerId) {
		this.wnPlayerId = wnPlayerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ResultEntityPK)) {
			return false;
		}
		ResultEntityPK castOther = (ResultEntityPK)other;
		return 
			(this.winnerId == castOther.winnerId)
			&& (this.wnEventId == castOther.wnEventId)
			&& (this.wnStaffId == castOther.wnStaffId)
			&& (this.wnPositionId == castOther.wnPositionId)
			&& (this.wnCharacterId == castOther.wnCharacterId)
			&& (this.wnServerId == castOther.wnServerId)
			&& (this.wnPlayerId == castOther.wnPlayerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.winnerId;
		hash = hash * prime + this.wnEventId;
		hash = hash * prime + ((int) this.wnStaffId);
		hash = hash * prime + ((int) this.wnPositionId);
		hash = hash * prime + this.wnCharacterId;
		hash = hash * prime + ((int) this.wnServerId);
		hash = hash * prime + this.wnPlayerId;
		
		return hash;
	}
}