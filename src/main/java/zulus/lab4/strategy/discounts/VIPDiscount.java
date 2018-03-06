package zulus.lab4.strategy.discounts;

import zulus.lab4.strategy.Discount;

/**
 * Created by zulus on 06.03.18
 */
public class VIPDiscount extends Discount {

    @Override
    public double getDiscount() {
        return 0.1;
    }
}