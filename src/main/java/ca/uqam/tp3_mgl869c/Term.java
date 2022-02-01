package ca.uqam.tp3_mgl869c;

public class Term {
    public final double coefficient;
    public final char   variable;
    public final int    exponent;
    
    /**
     * Build an instance of type Term
     *
     * @param coefficient Coefficient of a polynomial term
     * @param variable    Variable of a polynomial term
     * @param exponent    Exponent of a polynomial term
     */
    public Term(double coefficient, char variable, int exponent) throws ExceptionCoefficientZero {
        if (coefficient == 0)
            throw new ExceptionCoefficientZero();
        this.coefficient = coefficient;
        this.variable = variable;
        this.exponent = exponent;
    }
    
    /**
     * @return String representing the formatted term with the following format {coefficient}{variable}^{exponent}
     */
    @Override
    public String toString() {
        if (this.variable == ' ')
            return String.format("%s", formatDouble(this.coefficient));
        if (this.exponent == 1)
            return String.format("%s%s", formatDouble(this.coefficient), this.variable);
        return String.format("%s%s^%d", formatDouble(this.coefficient), this.variable, this.exponent);
    }
    
    private String formatDouble(double d) {
        if (d % 1 == 0) {
            return Integer.toString((int) d);
        }
        return Double.toString(d);
    }
}
