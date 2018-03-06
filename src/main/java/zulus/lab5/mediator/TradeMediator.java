package zulus.lab5.mediator;

import java.util.List;

/**
 * Created by zulus on 06.03.18
 */
public interface TradeMediator {

    List<Buyer> sell(Flat flat);

    List<Flat> buy(Buyer buyer);

}
