package zulus.lab1.bridge;

/**
 * Created by zulus on 21.02.18
 */
public class InvalidCalcModeException extends IllegalArgumentException {

    public InvalidCalcModeException() {
        super("This operation is not allowed in this mode of calculator");
    }
}
