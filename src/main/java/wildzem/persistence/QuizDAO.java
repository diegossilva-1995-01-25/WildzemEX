package wildzem.persistence;

import wildzem.model.Quiz;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Implementation of GenericDAO
 * 
 * T = Quiz
 * K = Integer
 * 
 */
public class QuizDAO extends GenericDAO<Quiz, Integer>{
    
    public QuizDAO() {
        super(Quiz.class);
    }
}
