package zulus.lab1.bridge;
/**
 * Created by zulus on 21.02.18
 */


/**
 * Defines simple calculator interface, that provides basic operations, like sun and multiplication
 */
public interface ICalculator {
    /**
     * sum of two numbers
     *
     * @param A first number
     * @param B second number
     * @return A+B
     */
    int sum(int A, int B);

    /**
     * multiply of two numbers
     *
     * @param A first number
     * @param B second number
     * @return A*B
     */
    long multiply(int A, int B);

    /**
     * divide A by B
     *
     * @param A dividend number
     * @param B divider number
     * @return A/B
     */
    double div(double A, double B);

    /**
     * subtracts B from A
     *
     * @param B minuend number
     * @param A subtrahend number
     * @return A-B
     */
    int subtract(int A, int B);

    /**
     * calculates square root of a number
     *
     * @param A number
     * @return square root of A
     */
    double sqrt(double A);

    /**
     * calculates remainder of the division
     *
     * @param A dividend
     * @param B divider
     * @return A%B
     */
    int divByModulo(int A, int B);

    /**
     * calculates A^pow
     *
     * @param A   base number
     * @param pow value of power
     * @return A^pow
     */
    double pow(double A, double pow);
}
