package org.wildzem.persistence;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_server database table.
 * 
 */
@Entity
@Table(name="tb_server")
@NamedQuery(name="ServerEntity.findAll", query="SELECT s FROM ServerEntity s")
public class ServerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sv_server_id", unique=true, nullable=false)
	private byte serverId;

	@Column(name="sv_code", columnDefinition = "CHAR", length=2)
	private String code;

	@Column(name="sv_location", length=10)
	private String location;

	@Column(name="sv_status", length=10)
	private String status;

	public ServerEntity() {
	}

	public byte getServerId() {
		return this.serverId;
	}

	public void setServerId(byte serverId) {
		this.serverId = serverId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}