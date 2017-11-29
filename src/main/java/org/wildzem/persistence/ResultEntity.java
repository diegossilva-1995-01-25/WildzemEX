package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;

import org.wildzem.persistence.keys.ResultEntityPK;


/**
 * The persistent class for the tb_winner_list database table.
 * 
 */
@Entity
@Table(name="tb_winner_list")
@NamedQuery(name="ResultEntity.findAll", query="SELECT r FROM ResultEntity r")
public class ResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResultEntityPK id;

	@Column(name="wn_prize", length=20)
	private String prize;

	@Column(name="wn_status", length=10)
	private String status;

	//uni-directional many-to-one association to EventEntity
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="wn_event_id", referencedColumnName="ev_event_id", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="wn_position_id", referencedColumnName="ev_position_id", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="wn_staff_id", referencedColumnName="ev_staff_id", nullable=false, insertable=false, updatable=false)
		})
	private EventEntity EventEntity;

	//uni-directional many-to-one association to CharacterEntity
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="wn_character_id", referencedColumnName="ch_character_id", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="wn_player_id", referencedColumnName="ch_player_id", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="wn_server_id", referencedColumnName="ch_server_id", nullable=false, insertable=false, updatable=false)
		})
	private CharacterEntity PlayerCharacterEntity;

	public ResultEntity() {
	}

	public ResultEntityPK getId() {
		return this.id;
	}

	public void setId(ResultEntityPK id) {
		this.id = id;
	}

	public String getPrize() {
		return this.prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EventEntity getEventEntity() {
		return this.EventEntity;
	}

	public void setEventEntity(EventEntity EventEntity) {
		this.EventEntity = EventEntity;
	}

	public CharacterEntity getPlayerCharacterEntity() {
		return this.PlayerCharacterEntity;
	}

	public void setPlayerCharacterEntity(CharacterEntity PlayerCharacterEntity) {
		this.PlayerCharacterEntity = PlayerCharacterEntity;
	}

}