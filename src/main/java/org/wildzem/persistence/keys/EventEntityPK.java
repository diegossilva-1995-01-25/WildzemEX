package org.wildzem.persistence.keys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_event database table.
 * 
 */
@Embeddable
public class EventEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ev_position_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte evPositionId;

	@Column(name="ev_staff_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte evStaffId;

	@Column(name="ev_event_id", unique=true, nullable=false)
	private int eventId;

	public EventEntityPK() {
	}
	public byte getEvPositionId() {
		return this.evPositionId;
	}
	public void setEvPositionId(byte evPositionId) {
		this.evPositionId = evPositionId;
	}
	public byte getEvStaffId() {
		return this.evStaffId;
	}
	public void setEvStaffId(byte evStaffId) {
		this.evStaffId = evStaffId;
	}
	public int getEventId() {
		return this.eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventEntityPK)) {
			return false;
		}
		EventEntityPK castOther = (EventEntityPK)other;
		return 
			(this.evPositionId == castOther.evPositionId)
			&& (this.evStaffId == castOther.evStaffId)
			&& (this.eventId == castOther.eventId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.evPositionId);
		hash = hash * prime + ((int) this.evStaffId);
		hash = hash * prime + this.eventId;
		
		return hash;
	}
}