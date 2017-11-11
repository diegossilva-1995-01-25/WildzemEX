package wildzem.persistence;

import wildzem.model.QuizCategory;

/**
 *
 * @author Caio
 * @version 1.0
 * 
 * Implementation of GenericDAO
 * 
 * T = QuizCategory
 * K = Integer
 * 
 */
public class QuizCategoryDAO extends GenericDAO<QuizCategory, String> {
   
    public QuizCategoryDAO() {
        super(QuizCategory.class);
    }  
}
