package prelim;

public interface PolynomialInterface {
    double evaluate(double x);
    Polynomial add(Polynomial other);
    Polynomial subtract(Polynomial other);
    Polynomial multiply(Polynomial other);
    Polynomial divide(Polynomial other);
}
