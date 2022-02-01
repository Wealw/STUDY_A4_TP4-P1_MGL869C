package ca.uqam.tp3_mgl869c;

import ca.uqam.tp3_mgl869c.polynomial.APolynomial;
import ca.uqam.tp3_mgl869c.polynomial.Polynomial;
import ca.uqam.tp3_mgl869c.polynomial.term.ExceptionCoefficientZero;
import ca.uqam.tp3_mgl869c.polynomial.term.Term;


public class main {
    @SuppressWarnings ("MethodNameSameAsClassName")
    public static void main(String[] args) {
        try {
            Mathematics mathematics = new Mathematics();
            Polynomial  p1          = new APolynomial();
            Polynomial  p2          = new APolynomial();
            p1.addTerm(new Term(1.5, ' ', 0));
            p1.addTerm(new Term(-4, ' ', 0));
            p1.addTerm(new Term(2, 'x', 1));
            p1.addTerm(new Term(8, 'x', 2));
            p2.addTerm(new Term(-20, 'y', 2));
            p2.addTerm(new Term(2, 'y', 10));
            p2.addTerm(new Term(9, 'y', 10));
            Polynomial p3 = mathematics.sumPolynomials(p1, p2);
            System.out.print(p3.toString());
        } catch (ExceptionCoefficientZero e) {
            e.printStackTrace();
        }
    }
}