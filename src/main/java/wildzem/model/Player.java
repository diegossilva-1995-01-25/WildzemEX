package wildzem.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Caio
 * @version 0.1
 * 
 * Entity/model for Players
 */
@Entity
@Table(name="tb_player")
public class Player implements Serializable {

    
    @Id
    @Column(name="PL_PLAYERID")
    private int id;
    
    @Column(name="PL_CHARACTER")
    private String character;
    
    @Column(name="PL_LOGIN")
    private String login;
    
    @Column(name="PL_WIN_COUNT")
    private int winCount;
    
    @Column(name="PL_STATUS")
    private String status;
	
    /*
     * Getter/Setter section
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
              
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
	
    public String getLogin() {
        return login;
    }	
    public void setLogin(String login) {
        this.login = login;
    }
		
    public int getWinCount() {
        return winCount;
    }	
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
		
    public String getStatus() {
        return status;
    }	
    public void setStatus(String status) {
        this.status = status;
    }
}
