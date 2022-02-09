import ca.uqam.tp4_p1_mgl869c.polynomial.LLPolynomial;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.ExceptionCoefficientZero;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.Term;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class LLPolynomialTest {
    
    LLPolynomial aPolynomial;
    
    @Before
    public void init() {
        aPolynomial = new LLPolynomial();
    }
    
    @Test
    public void testAddTerm() throws ExceptionCoefficientZero {
        final int size = 100;
        for (int i = 0; i < size; i++) {
            this.aPolynomial.addTerm(new Term(1, 'x', 1));
        }
        boolean result = this.aPolynomial.addTerm(new Term(1, 'x', 1));
        assertTrue(result);
    }
    
    @Test
    public void testGetNumberTerms() throws ExceptionCoefficientZero {
        this.aPolynomial.addTerm(new Term(1, 'x', 1));
        this.aPolynomial.addTerm(null);
        this.aPolynomial.addTerm(new Term(1, 'x', 1));
        int expected = 2;
        int result   = this.aPolynomial.getNumberTerms();
        assertEquals(expected, result);
    }
    
    @Test
    public void testRemoveTermInList() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 1);
        Term t2 = new Term(1, 'x', 2);
        this.aPolynomial.addTerm(t1);
        this.aPolynomial.addTerm(t2);
        boolean result = this.aPolynomial.removeTerm(t1);
        assertTrue(result);
    }
    
    @Test
    public void testRemoveTermNotInList() throws ExceptionCoefficientZero {
        Term    t      = new Term(1, 'x', 1);
        boolean result = this.aPolynomial.removeTerm(t);
        assertFalse(result);
    }
    
    
    @Test
    public void testGetExponents() throws ExceptionCoefficientZero {
        this.aPolynomial.addTerm(new Term(1, 'x', 0));
        this.aPolynomial.addTerm(new Term(1, 'x', 1));
        this.aPolynomial.addTerm(new Term(1, 'x', 5));
        List<Integer> result   = this.aPolynomial.getExponents();
        List<Integer> expected = new LinkedList<>();
        expected.add(0);
        expected.add(1);
        expected.add(5);
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetVariable() throws ExceptionCoefficientZero {
        this.aPolynomial.addTerm(new Term(1, 'x', 0));
        this.aPolynomial.addTerm(new Term(1, 'y', 1));
        this.aPolynomial.addTerm(new Term(1, 'z', 5));
        List<Character> result   = this.aPolynomial.getVariables();
        List<Character> expected = new LinkedList<>();
        expected.add('x');
        expected.add('y');
        expected.add('z');
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetTerms() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 5);
        Term t2 = new Term(1, 'y', 1);
        Term t3 = new Term(1, 'x', 5);
        this.aPolynomial.addTerm(t1);
        this.aPolynomial.addTerm(t2);
        this.aPolynomial.addTerm(t3);
        List<Term> result   = this.aPolynomial.getTerms('x', 5);
        List<Term> expected = List.of(new Term[] {t1, t3});
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetAllTerms() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 5);
        Term t2 = new Term(1, 'y', 1);
        Term t3 = new Term(1, 'x', 5);
        this.aPolynomial.addTerm(t1);
        this.aPolynomial.addTerm(t2);
        this.aPolynomial.addTerm(t3);
        List<Term> result   = this.aPolynomial.getAllTerms();
        List<Term> expected = List.of(new Term[] {t1, t2, t3});
        assertEquals(expected, result);
    }
    
    @Test
    public void testToString() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 5);
        Term t2 = new Term(1, 'y', 1);
        Term t3 = new Term(1, 'x', 5);
        this.aPolynomial.addTerm(t1);
        this.aPolynomial.addTerm(t2);
        this.aPolynomial.addTerm(t3);
        String result   = this.aPolynomial.toString();
        String expected = String.format("%s+%s+%s", t1, t2, t3);
        assertEquals(expected, result);
    }
}
