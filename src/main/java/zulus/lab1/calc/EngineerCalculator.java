package zulus.lab1.calc;

/**
 * Created by zulus on 21.02.18
 */


/**
 * Defines engineer Calculator, that provides next operations
 * square root, exponentiation, divide by modulo + operation of SimpleCalculator
 */
public class EngineerCalculator implements ICalculator {

    @Override
    public int sum(int A, int B) {
        return A + B;
    }

    @Override
    public long multiply(int A, int B) {
        return A * B;
    }

    @Override
    public double div(double A, double B) {
        return A / B;
    }

    @Override
    public int subtract(int A, int B) {
        return A - B;
    }

    @Override
    public double sqrt(double A) {
        return Math.sqrt(A);
    }

    @Override
    public int divByModulo(int A, int B) {
        return A % B;
    }

    @Override
    public double pow(double A, double pow) {
        return Math.pow(A, pow);
    }
}
