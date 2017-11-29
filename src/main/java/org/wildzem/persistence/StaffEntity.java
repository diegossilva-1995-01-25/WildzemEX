package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;

import org.wildzem.persistence.keys.StaffEntityPK;


/**
 * The persistent class for the tb_staff database table.
 * 
 */
@Entity
@Table(name="tb_staff")
@NamedQueries({
	@NamedQuery(name="StaffEntity.findAll", query="SELECT s FROM StaffEntity s"),
	@NamedQuery(name="StaffEntity.validate", query="SELECT s FROM StaffEntity s WHERE s.login = :login AND s.password = :pass")
})
public class StaffEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StaffEntityPK id;

	@Column(name="st_email", length=30)
	private String email;

	@Column(name="st_login", length=15)
	private String login;

	@Column(name="st_name", length=10)
	private String name;

	@Column(name="st_password", length=20)
	private String password;

	@Column(name="st_status", length=10)
	private String status;

	//uni-directional many-to-one association to PositionEntity
	@ManyToOne
	@JoinColumn(name="st_position_id", nullable=false, insertable=false, updatable=false)
	private PositionEntity PositionEntity;

	public StaffEntity() {
	}

	public StaffEntityPK getId() {
		return this.id;
	}

	public void setId(StaffEntityPK id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PositionEntity getPositionEntity() {
		return this.PositionEntity;
	}

	public void setPositionEntity(PositionEntity PositionEntity) {
		this.PositionEntity = PositionEntity;
	}

}