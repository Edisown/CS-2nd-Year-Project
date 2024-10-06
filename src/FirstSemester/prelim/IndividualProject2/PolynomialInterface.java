/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 * Prelim Individual Project 2
 */

package prelim;

/**
 * Interface for polynomial operations, including evaluation, addition,
 * subtraction, multiplication, and division of polynomials.
 */
public interface PolynomialInterface {

    /**
     * Evaluates the polynomial for a given value of x.
     *
     * @param x the value to evaluate the polynomial at
     * @return the result of the evaluation
     */
    double evaluate(double x);

    /**
     * Adds this polynomial to another polynomial and returns the result.
     *
     * @param other the polynomial to add
     * @return the resulting polynomial after addition
     */
    Polynomial add(Polynomial other);

    /**
     * Subtracts another polynomial from this polynomial and returns the result.
     *
     * @param other the polynomial to subtract
     * @return the resulting polynomial after subtraction
     */
    Polynomial subtract(Polynomial other);

    /**
     * Multiplies this polynomial by another polynomial and returns the result.
     *
     * @param other the polynomial to multiply by
     * @return the resulting polynomial after multiplication
     */
    Polynomial multiply(Polynomial other);

    /**
     * Divides this polynomial by another polynomial and returns the quotient.
     *
     * @param other the polynomial to divide by
     * @return the quotient polynomial after division
     */
    Polynomial divide(Polynomial other);
}
