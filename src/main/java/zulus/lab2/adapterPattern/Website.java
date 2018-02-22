package zulus.lab2.adapterPattern;

/**
 * Created by zulus on 22.02.18
 */

/**
 * Defines 'target' class of adapterPattern structure
 */
public class Website implements IWebsite {
    public final int ADULT_AGE = 35;

    private AdultWebsite _forAdult;
    private JuniorWebsite _forJunior;

    public Website() {
        _forAdult = new AdultWebsite();
        _forJunior = new JuniorWebsite();
    }

    @Override
    public String enterToService(Visitor visitor) {
        if (visitor == null) throw new IllegalArgumentException("Argument visitor must be not-null value");
        if (visitor.getAge() < ADULT_AGE) {
            return _forJunior.enterToService(visitor);
        } else {
            return _forAdult.enterToService(visitor);
        }
    }
}
