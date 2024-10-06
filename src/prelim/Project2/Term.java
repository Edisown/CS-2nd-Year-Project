/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 * Prelim Individual Project 2
 */

package prelim;

/**
 * Represents a term in a polynomial, consisting of a numerical coefficient,
 * a literal coefficient (e.g., "x"), and an exponent.
 */
public class Term implements Comparable<Term> {
    private int numericalCoefficient; // 1,2,3
    private String literalCoefficient; // e.g., "x"
    private int exponent; //  (^2) ex. 3x^2

    /**
     * Constructs a Term with a given numerical coefficient, literal coefficient, and exponent.
     *
     * @param numericalCoefficient the numerical coefficient of the term
     * @param literalCoefficient the literal coefficient (e.g., "x")
     * @param exponent the exponent of the term
     */
    public Term(int numericalCoefficient, String literalCoefficient, int exponent) {
        this.numericalCoefficient = numericalCoefficient; // Updated constructor
        this.literalCoefficient = literalCoefficient;
        this.exponent = exponent;
    }

    // Getters and Setters

    /**
     * Returns the numerical coefficient of the term.
     *
     * @return the numerical coefficient
     */
    public int getNumericalCoefficient() {
        return numericalCoefficient; // Updated return type
    }

    /**
     * Sets the numerical coefficient of the term.
     *
     * @param numericalCoefficient the numerical coefficient to set
     */
    public void setNumericalCoefficient(int numericalCoefficient) {
        this.numericalCoefficient = numericalCoefficient; // Updated setter
    }

    /**
     * Returns the literal coefficient of the term.
     *
     * @return the literal coefficient
     */
    public String getLiteralCoefficient() {
        return literalCoefficient;
    }

    /**
     * Sets the literal coefficient of the term.
     *
     * @param literalCoefficient the literal coefficient to set
     */
    public void setLiteralCoefficient(String literalCoefficient) {
        this.literalCoefficient = literalCoefficient;
    }

    /**
     * Returns the exponent of the term.
     *
     * @return the exponent
     */
    public int getExponent() {
        return exponent;
    }

    /**
     * Sets the exponent of the term.
     *
     * @param exponent the exponent to set
     */
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    /**
     * Returns a string representation of the term, including the numerical coefficient,
     * literal coefficient, and exponent. Handles special cases such as zero coefficients
     * and exponents of 1.
     *
     * @return a string representation of the term
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (numericalCoefficient < 0) {
            sb.append(numericalCoefficient); // Will include negative sign
        } else if (numericalCoefficient == 0) {
            return "0"; // Handle zero coefficient
        } else {
            sb.append(numericalCoefficient);
        }

        if (exponent == 1) {
            sb.append(literalCoefficient); // x
        } else if (exponent > 1) {
            sb.append(literalCoefficient).append("^").append(exponent); // x^2, x^3, etc.
        }

        return sb.toString();
    }

    /**
     * Compares this term to another term based on the exponent.
     *
     * @param o the term to compare to
     * @return a negative integer, zero, or a positive integer as this term's
     * exponent is less than, equal to, or greater than the specified term's exponent.
     */
    @Override
    public int compareTo(Term o) {
        return Integer.compare(this.exponent, o.exponent);
    }
}
