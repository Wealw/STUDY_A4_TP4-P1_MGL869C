import ca.uqam.tp4_p1_mgl869c.polynomial.TermComparator;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.ExceptionCoefficientZero;
import ca.uqam.tp4_p1_mgl869c.polynomial.term.Term;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TermComparatorTest {
    
    TermComparator termComparator;
    
    @Before
    public void init() {
        termComparator = new TermComparator();
    }
    
    @Test
    public void testCompareEquals() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 2);
        Term t2 = new Term(1, 'x', 2);
        int  r1 = termComparator.compare(t1, t2);
        int  e1 = 0;
        Assert.assertEquals(e1, r1);
    }
    
    @Test
    public void testCompareVariableLesser() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 2);
        Term t2 = new Term(1, 'a', 2);
        int  r1 = termComparator.compare(t1, t2);
        int  e1 = 1;
        Assert.assertEquals(e1, r1);
    }
    
    @Test
    public void testCompareVariableGreater() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'a', 2);
        Term t2 = new Term(1, 'x', 2);
        int  r1 = termComparator.compare(t1, t2);
        int  e1 = -1;
        Assert.assertEquals(e1, r1);
    }
    
    @Test
    public void testCompareExponentLesser() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 1);
        Term t2 = new Term(1, 'x', 2);
        int  r1 = termComparator.compare(t1, t2);
        int  e1 = 1;
        Assert.assertEquals(e1, r1);
    }
    
    @Test
    public void testCompareExponentGreater() throws ExceptionCoefficientZero {
        Term t1 = new Term(1, 'x', 2);
        Term t2 = new Term(1, 'x', 1);
        int  r1 = termComparator.compare(t1, t2);
        int  e1 = -1;
        Assert.assertEquals(e1, r1);
    }
}
