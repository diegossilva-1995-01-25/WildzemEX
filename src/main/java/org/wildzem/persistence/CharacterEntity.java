package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;

import org.wildzem.persistence.keys.CharacterEntityPK;


/**
 * The persistent class for the tb_player_character database table.
 * 
 */
@Entity
@Table(name="tb_player_character")
@NamedQuery(name="CharacterEntity.findAll", query="SELECT c FROM CharacterEntity c")
public class CharacterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CharacterEntityPK id;

	@Column(name="ch_name", length=10)
	private String name;

	//uni-directional many-to-one association to PlayerEntity
	@ManyToOne
	@JoinColumn(name="ch_player_id", nullable=false, insertable=false, updatable=false)
	private PlayerEntity PlayerEntity;

	//uni-directional many-to-one association to ServerEntity
	@ManyToOne
	@JoinColumn(name="ch_server_id", nullable=false, insertable=false, updatable=false)
	private ServerEntity ServerEntity;

	public CharacterEntity() {
	}

	public CharacterEntityPK getId() {
		return this.id;
	}

	public void setId(CharacterEntityPK id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerEntity getPlayerEntity() {
		return this.PlayerEntity;
	}

	public void setPlayerEntity(PlayerEntity PlayerEntity) {
		this.PlayerEntity = PlayerEntity;
	}

	public ServerEntity getServerEntity() {
		return this.ServerEntity;
	}

	public void setServerEntity(ServerEntity ServerEntity) {
		this.ServerEntity = ServerEntity;
	}

}