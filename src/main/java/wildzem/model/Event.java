package wildzem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_event")
public class Event implements Serializable {
    private static final long serialVersionUID = -1415507314234384840L;
	
    @Id
    @Column(name="EV_DATE")
    private LocalDate date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns( {
        @JoinColumn(name = "EV_HOSTER", nullable = false, referencedColumnName = "ST_USERID"),
        @JoinColumn(name = "EV_HOSTER_POSITION", nullable = false, referencedColumnName = "ST_POSITION")
    } )
    private Staff staff;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns( {
        @JoinColumn(name = "EV_WINNER", nullable = false, referencedColumnName = "PL_PLAYERID"),
        @JoinColumn(name = "EV_SERVER", nullable = false, referencedColumnName = "PL_SERVER")
    } )
    private List<Player> player;
    private List<String> prize;
    private List<String> status;

    /*
     * Getter/Setter section
     */
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Staff getStaff() {
        return staff;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Player> getPlayer() {
        return player;
    }
    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<String> getPrize() {
        return prize;
    }
    public void setPrize(List<String> prize) {
        this.prize = prize;
    }

    public List<String> getStatus() {
        return status;
    }
    public void setStatus(List<String> status) {
        this.status = status;
    }
    
    /*
     * Equals/Hash Code section
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.date);
        hash = 89 * hash + Objects.hashCode(this.staff);
        hash = 89 * hash + Objects.hashCode(this.player);
        hash = 89 * hash + Objects.hashCode(this.prize);
        hash = 89 * hash + Objects.hashCode(this.status);
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.staff, other.staff)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        if (!Objects.equals(this.prize, other.prize)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }
    
}
