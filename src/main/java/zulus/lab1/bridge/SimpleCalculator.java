package zulus.lab1.bridge;

/**
 * Created by zulus on 21.02.18
 */

/**
 * Defines simple Calculator, that provides next operations
 * sum, subtraction, dividing, multiplication
 */
public class SimpleCalculator implements ICalculator {

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
        throw new UnsupportedOperationException("Simple calculator cannot do this");
    }

    @Override
    public int divByModulo(int A, int B) {
        throw new UnsupportedOperationException("Simple calculator cannot do this");
    }

    @Override
    public double pow(double A, double pow) {
        throw new UnsupportedOperationException("Simple calculator cannot do this");
    }
}
