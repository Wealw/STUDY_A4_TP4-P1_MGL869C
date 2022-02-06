import ca.uqam.tp3_mgl869c.Mathematics;
import ca.uqam.tp3_mgl869c.polynomial.APolynomial;
import ca.uqam.tp3_mgl869c.polynomial.Polynomial;
import ca.uqam.tp3_mgl869c.polynomial.term.ExceptionCoefficientZero;
import ca.uqam.tp3_mgl869c.polynomial.term.Term;
import org.junit.Assert;
import org.junit.Test;

public class MathematicsTest {
    
    @Test
    public void testSimplify() throws ExceptionCoefficientZero {
        Polynomial polynomial = new APolynomial();
        polynomial.addTerm(new Term(1.5, ' ', 0));
        polynomial.addTerm(new Term(-4, ' ', 0));
        polynomial.addTerm(new Term(2, 'x', 1));
        polynomial.addTerm(new Term(8, 'x', 2));
        polynomial.addTerm(new Term(-20, 'y', 2));
        polynomial.addTerm(new Term(2, 'y', 10));
        polynomial.addTerm(new Term(9, 'y', 10));
        Mathematics.simplify(polynomial);
        String result   = polynomial.toString();
        String expected = "-2.5+2x+8x^2+-20y^2+11y^10";
        Assert.assertEquals(expected, result);
    }
    
    @Test
    public void testSumPolynomial() throws ExceptionCoefficientZero {
        Polynomial p1 = new APolynomial();
        Polynomial p2 = new APolynomial();
        p1.addTerm(new Term(1.5, ' ', 0));
        p1.addTerm(new Term(-4, ' ', 0));
        p1.addTerm(new Term(2, 'x', 1));
        p1.addTerm(new Term(8, 'x', 2));
        p2.addTerm(new Term(-20, 'y', 2));
        p2.addTerm(new Term(2, 'y', 10));
        p2.addTerm(new Term(9, 'y', 10));
        Polynomial p3       = Mathematics.sumPolynomials(p1, p2);
        String     result   = p3.toString();
        String     expected = "-2.5+2x+8x^2+-20y^2+11y^10";
        Assert.assertEquals(expected, result);
    }
}
