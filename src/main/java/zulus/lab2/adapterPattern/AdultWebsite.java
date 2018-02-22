package zulus.lab2.adapterPattern;

/**
 * Created by zulus on 22.02.18
 */

/**
 * defines website, that is used for adult users
 */
public class AdultWebsite implements IWebsite {
    @Override
    public String enterToService(Visitor visitor) {
        if (visitor == null) throw new IllegalArgumentException("Argument visitor must be not-null value");
        return String.format("Добрый день, %s", visitor.getName());
    }
}
