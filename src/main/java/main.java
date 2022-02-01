import ca.uqam.tp3_mgl869c.ExceptionCoefficientZero;
import ca.uqam.tp3_mgl869c.Term;

public class main {
    Term term;
    
    {
        try {
            term = new Term(1, 'n', 3);
        } catch (ExceptionCoefficientZero e) {
            e.printStackTrace();
        }
    }
}
