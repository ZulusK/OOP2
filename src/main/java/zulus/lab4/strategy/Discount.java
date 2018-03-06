package zulus.lab4.strategy;

/**
 * Created by zulus on 06.03.18
 */

import java.text.DecimalFormat;

/**
 * defines interface of strategy pattern
 */
public abstract class Discount {
    /**
     * get discounts
     *
     * @return discounts
     */
    public abstract double getDiscount();

    @Override
    public String toString() {
        return new DecimalFormat("#,##0.00'%'").format(getDiscount() * 100);
    }
}
