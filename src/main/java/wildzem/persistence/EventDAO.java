package wildzem.persistence;

import java.util.Date;
import wildzem.model.Event;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Implementation of GenericDAO
 * 
 * T = Event    
 * K = Date
 * 
 */
public class EventDAO extends GenericDAO<Event, Date> {
    
    public EventDAO() {
        super(Event.class);
    }
}
