package zulus.lab2.adapter;

/**
 * Created by zulus on 22.02.18
 */

/**
 * defines website, that is used for adult users
 */
public class AdultWebsite {
    public String meetAdult(Visitor visitor) {
        if (visitor == null) throw new IllegalArgumentException("Argument visitor must be not-null value");
        return String.format("Добрый день, %s", visitor.getName());
    }
}
