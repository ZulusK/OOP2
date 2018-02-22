package zulus.lab2.wesite;

/**
 * Created by zulus on 22.02.18
 */

/**
 * defines website, that is used for young users
 */
public class JuniorWebsite implements IWebsite {
    @Override
    public String enterToService(Visitor visitor) {
        if (visitor == null) throw new IllegalArgumentException("Argument visitor must be not-null value");
        return String.format("Привет, %s", visitor.getName());
    }
}

