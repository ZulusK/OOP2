package zulus.lab2.adapter;

/**
 * Created by zulus on 22.02.18
 */

/**
 * defines website, that is used for young users
 */
public class DefaultWebsite implements IWebsite {
    @Override
    public String enterToService(Visitor visitor) {
        if (visitor == null) throw new IllegalArgumentException("Argument visitor must be not-null value");
        return String.format("Привет, %s", visitor.getName());
    }
}

