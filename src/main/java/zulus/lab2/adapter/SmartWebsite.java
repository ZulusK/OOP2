package zulus.lab2.adapter;

/**
 * Created by zulus on 22.02.18
 */

/**
 * Defines 'target' class of adapter structure
 */
public class SmartWebsite extends DefaultWebsite {
    public final int ADULT_AGE = 35;
    private AdultWebsite _forAdult;
    private DefaultWebsite _default;

    public SmartWebsite() {
        _forAdult = new AdultWebsite();
        _default = new DefaultWebsite();
    }

    @Override
    public String enterToService(Visitor visitor) {
        if (visitor == null) throw new IllegalArgumentException("Argument visitor must be not-null value");
        if (visitor.getAge() < ADULT_AGE) {
            return _default.enterToService(visitor);
        } else {
            return _forAdult.meetAdult(visitor);
        }
    }
}
