package org.wildzem.model;


import java.io.Serializable;

import javax.enterprise.inject.Model;


/**
 * The model class for Character
 * 
 */
@Model
public class CharacterModel implements Serializable {
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 3084557160298116656L;
	
	
	/*
	 * Attribute section
	 */
	private int characterId;
	private String name;
	private PlayerModel player;
	private ServerModel server;
	
	
	/*
	 * Getter/Setter section
	 */
	public int getCharacterId() {
		return characterId;
	}
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public PlayerModel getPlayer() {
		return player;
	}
	public void setPlayer(PlayerModel player) {
		this.player = player;
	}
	
	
	public ServerModel getServer() {
		return server;
	}
	public void setServer(ServerModel server) {
		this.server = server;
	}
	
	
	/*
	 * HashCode / Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + characterId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((server == null) ? 0 : server.hashCode());
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
		CharacterModel other = (CharacterModel) obj;
		if (characterId != other.characterId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		return true;
	}

}