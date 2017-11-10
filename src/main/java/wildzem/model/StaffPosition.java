package wildzem.model;

import java.io.Serializable;

public class StaffPosition implements Serializable {
	private static final long serialVersionUID = 6321239456551563859L;
	
	private String code;
	private String position;
	private String description;
	
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
