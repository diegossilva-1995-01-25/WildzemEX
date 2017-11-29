package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;

import org.wildzem.persistence.keys.EventEntityPK;

import java.util.Date;


/**
 * The persistent class for the tb_event database table.
 * 
 */
@Entity
@Table(name="tb_event")
@NamedQuery(name="EventEntity.findAll", query="SELECT e FROM EventEntity e")
public class EventEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventEntityPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="ev_date")
	private Date date;

	@Temporal(TemporalType.TIME)
	@Column(name="ev_end_time")
	private Date endTime;

	@Temporal(TemporalType.TIME)
	@Column(name="ev_start_time")
	private Date startTime;

	//uni-directional many-to-one association to StaffEntity
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ev_position_id", referencedColumnName="st_staff_id", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="ev_staff_id", referencedColumnName="st_position_id", nullable=false, insertable=false, updatable=false)
		})
	private StaffEntity StaffEntity;

	public EventEntity() {
	}

	public EventEntityPK getId() {
		return this.id;
	}

	public void setId(EventEntityPK id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public StaffEntity getStaffEntity() {
		return this.StaffEntity;
	}

	public void setStaffEntity(StaffEntity StaffEntity) {
		this.StaffEntity = StaffEntity;
	}

}