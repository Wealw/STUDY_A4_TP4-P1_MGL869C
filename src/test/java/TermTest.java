import ca.uqam.tp3_mgl869c.ExceptionCoefficientZero;
import ca.uqam.tp3_mgl869c.Term;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TermTest {
    
    @Test
    public void nullCoefficientPassedToConstructor() {
        try {
            Term term = new Term(0, 'x', 3);
            Assert.fail();
        } catch (ExceptionCoefficientZero ignored) {}
    }
    
    @Test
    public void testToString() {
        String expected = "1.2x^3";
        try {
            Term   term   = new Term(1.2, 'x', 3);
            String result = term.toString();
            assertEquals(result, expected);
        } catch (ExceptionCoefficientZero e) {
            fail();
        }
    }
}
