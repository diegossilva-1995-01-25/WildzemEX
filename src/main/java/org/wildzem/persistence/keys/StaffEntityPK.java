package org.wildzem.persistence.keys;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_staff database table.
 * 
 */
@Embeddable
public class StaffEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="st_staff_id", unique=true, nullable=false)
	private byte staffId;

	@Column(name="st_position_id", insertable=false, updatable=false, unique=true, nullable=false)
	private byte stPositionId;

	public StaffEntityPK() {
	}
	public byte getStaffId() {
		return this.staffId;
	}
	public void setStaffId(byte staffId) {
		this.staffId = staffId;
	}
	public byte getStPositionId() {
		return this.stPositionId;
	}
	public void setStPositionId(byte stPositionId) {
		this.stPositionId = stPositionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StaffEntityPK)) {
			return false;
		}
		StaffEntityPK castOther = (StaffEntityPK)other;
		return 
			(this.staffId == castOther.staffId)
			&& (this.stPositionId == castOther.stPositionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.staffId);
		hash = hash * prime + ((int) this.stPositionId);
		
		return hash;
	}
}