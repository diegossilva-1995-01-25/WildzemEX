package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_player database table.
 * 
 */
@Entity
@Table(name="tb_player")
@NamedQuery(name="PlayerEntity.findAll", query="SELECT p FROM PlayerEntity p")
public class PlayerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pl_player_id", unique=true, nullable=false)
	private int playerId;

	@Column(name="pl_ingame_login", length=15)
	private String inGameLogin;

	@Column(name="pl_status", length=10)
	private String status;

	@Column(name="pl_win_count")
	private short winCount;

	public PlayerEntity() {
	}

	public int getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getInGameLogin() {
		return this.inGameLogin;
	}

	public void setInGameLogin(String inGameLogin) {
		this.inGameLogin = inGameLogin;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public short getWinCount() {
		return this.winCount;
	}

	public void setWinCount(short winCount) {
		this.winCount = winCount;
	}

}