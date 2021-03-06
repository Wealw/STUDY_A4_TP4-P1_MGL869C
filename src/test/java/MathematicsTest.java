import ca.uqam.tp4_p1_mgl869c.Mathematics;
import ca.uqam.tp4_p1_mgl869c.polynomial.LLPolynomial;
import ca.uqam.tp4_p1_mgl869c.polynomial.Polynomial;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.ExceptionCoefficientZero;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.Term;
import org.junit.Assert;
import org.junit.Test;

public class MathematicsTest {
    
    @Test
    public void testSimplify() throws ExceptionCoefficientZero {
        Polynomial polynomial = new LLPolynomial();
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
        Polynomial p1 = new LLPolynomial();
        Polynomial p2 = new LLPolynomial();
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
    
    @Test
    public void testSort() throws ExceptionCoefficientZero {
        Polynomial p1 = new LLPolynomial();
        p1.addTerm(new Term(4, 'x', 1));
        p1.addTerm(new Term(4, 'y', 1));
        p1.addTerm(new Term(2, 'x', 3));
        p1.addTerm(new Term(2, 'y', 3));
        p1.addTerm(new Term(3, 'x', 2));
        p1.addTerm(new Term(3, 'y', 2));
        Polynomial p2       = Mathematics.sort(p1);
        String     result   = p2.toString();
        String     expected = "2x^3+3x^2+4x+2y^3+3y^2+4y";
        Assert.assertEquals(expected, result);
    }
}
