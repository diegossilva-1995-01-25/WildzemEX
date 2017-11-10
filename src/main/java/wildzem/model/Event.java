package wildzem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Event implements Serializable {
	private static final long serialVersionUID = -1415507314234384840L;
	
	private Date date;
	private byte winnerNumber;
	private String prize;
	private List<String> status;
	private Date startTime;
	private Date endTime;
	private List<Player> player;
	private Staff staff;
	
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public byte getWinnerNumber() {
		return winnerNumber;
	}
	
	public void setWinnerNumber(byte winnerNumber) {
		this.winnerNumber = winnerNumber;
	}
	
	public String getPrize() {
		return prize;
	}
	
	public void setPrize(String prize) {
		this.prize = prize;
	}
	
	public List<String> getStatus() {
		return status;
	}
	
	public void setStatus(List<String> status) {
		this.status = status;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public List<Player> getPlayer() {
		return player;
	}
	
	public void setPlayer(List<Player> player) {
		this.player = player;
	}
	
	public Staff getStaff() {
		return staff;
	}
	
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}
