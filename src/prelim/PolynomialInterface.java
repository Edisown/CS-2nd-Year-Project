/**
 * Author:
 * <p> Edison M. Malasan </p>
 * CS211 - 9344(A/B)
 */

package prelim;

public interface PolynomialInterface {
    double evaluate(double x);
    Polynomial add(Polynomial other);
    Polynomial subtract(Polynomial other);
    Polynomial multiply(Polynomial other);
    Polynomial divide(Polynomial other);
}
