package zulus.lab1.bridge;
/**
 * Created by zulus on 21.02.18
 */


/**
 * Defines calculator, using pattern Bridge
 */
public class AbstractCalculator {
    private ICalculator _calculator;

    /**
     * get calculator, that is used in runtime
     *
     * @return calculator, that is used in runtime
     */
    public ICalculator getCalculator() {
        return _calculator;
    }

    /**
     * set calculator, that is used in runtime
     *
     * @param calculator new calculator value
     */
    public void setCalculator(ICalculator calculator) {
        if (calculator == null) throw new IllegalArgumentException("Argument calculator must be not-null value");
        this._calculator = calculator;
    }

    /**
     * creates new AbstractCalculator with specific calculator
     *
     * @param calculator calculator, that will be used in runtime
     */
    public AbstractCalculator(ICalculator calculator) {
        if (calculator == null) throw new IllegalArgumentException("Argument calculator must be not-null value");
        this._calculator = calculator;
    }

    /**
     * sum of two numbers
     *
     * @param A first number
     * @param B second number
     * @return A+B
     */
    public int sum(int A, int B) {
        return _calculator.sum(A, B);
    }

    /**
     * multiply of two numbers
     *
     * @param A first number
     * @param B second number
     * @return A*B
     */
    public long multiply(int A, int B) {
        return _calculator.multiply(A, B);
    }

    /**
     * divide A by B
     *
     * @param A dividend number
     * @param B divider number
     * @return A/B
     */
    public double div(double A, double B) {
        return _calculator.div(A, B);
    }

    /**
     * subtracts B from A
     *
     * @param B minuend number
     * @param A subtrahend number
     * @return A-B
     */
    public int subtract(int A, int B) {
        return _calculator.subtract(A, B);
    }

    /**
     * calculates square root of a number
     *
     * @param A number
     * @return square root of A
     */
    public double sqrt(double A) {
        return _calculator.sqrt(A);
    }

    /**
     * calculates remainder of the division
     *
     * @param A dividend
     * @param B divider
     * @return A%B
     */
    public int divByModulo(int A, int B) {
        return _calculator.divByModulo(A, B);
    }

    /**
     * calculates A^pow
     *
     * @param A   base number
     * @param pow value of power
     * @return A^pow
     */
    public double pow(double A, double pow) {
        return _calculator.pow(A, pow);
    }

    /**
     * check, is this calculator in engineer mode
     *
     * @return true, if calculator is in engineer mode, else return false
     */
    public boolean isInEngineerMode() {
        return _calculator instanceof EngineerCalculator;
    }
}
