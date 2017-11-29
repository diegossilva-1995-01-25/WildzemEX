package org.wildzem.persistence.keys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_player_character database table.
 * 
 */
@Embeddable
public class CharacterEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ch_character_id", unique=true, nullable=false)
	private int characterId;

	@Column(name="ch_server_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte chServerId;

	@Column(name="ch_player_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int chPlayerId;

	public CharacterEntityPK() {
	}
	public int getCharacterId() {
		return this.characterId;
	}
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
	public byte getChServerId() {
		return this.chServerId;
	}
	public void setChServerId(byte chServerId) {
		this.chServerId = chServerId;
	}
	public int getChPlayerId() {
		return this.chPlayerId;
	}
	public void setChPlayerId(int chPlayerId) {
		this.chPlayerId = chPlayerId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CharacterEntityPK)) {
			return false;
		}
		CharacterEntityPK castOther = (CharacterEntityPK)other;
		return 
			(this.characterId == castOther.characterId)
			&& (this.chServerId == castOther.chServerId)
			&& (this.chPlayerId == castOther.chPlayerId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.characterId;
		hash = hash * prime + ((int) this.chServerId);
		hash = hash * prime + this.chPlayerId;
		
		return hash;
	}
}