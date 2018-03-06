package zulus.lab4.state;

/**
 * Created by zulus on 06.03.18
 */
public class Cleaner {
    DeepCleaning _DC;
    LightCleaning _LC;
    NormalCleaning _NC;

    ICleaning currentState;

    public Cleaner() {
        this._DC = new DeepCleaning();
        this._LC = new LightCleaning();
        this._NC = new NormalCleaning();
    }

    public String clean() {
        if (currentState != null) {
            return currentState.clean();
        } else {
            throw new IllegalArgumentException("State of cleaner is not selected");
        }
    }

    public void setState(State mode) {
        if (mode == null) throw new IllegalArgumentException("Argument mode must be not-null value");
        switch (mode) {
            case DEEP:
                currentState = _DC;
                break;
            case LIGHT:
                currentState = _LC;
                break;
            case NORMAL:
            default:
                currentState = _NC;
                break;
        }
    }
}
