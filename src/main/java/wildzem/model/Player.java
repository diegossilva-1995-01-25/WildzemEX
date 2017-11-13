package wildzem.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PL_SERVER", nullable = false, referencedColumnName = "SV_SERVERID")
    private Server server;
	
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

    public Server getServer() {
        return server;
    }
    public void setServer(Server server) {
        this.server = server;
    }
    
    /*
     * Equals/Hash Code section
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.character);
        hash = 47 * hash + Objects.hashCode(this.login);
        hash = 47 * hash + this.winCount;
        hash = 47 * hash + Objects.hashCode(this.status);
        hash = 47 * hash + Objects.hashCode(this.server);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.winCount != other.winCount) {
            return false;
        }
        if (!Objects.equals(this.character, other.character)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.server, other.server)) {
            return false;
        }
        return true;
    }
    
}
