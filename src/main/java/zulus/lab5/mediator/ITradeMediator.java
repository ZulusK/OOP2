package zulus.lab5.mediator;

import java.util.Set;

/**
 * Created by zulus on 06.03.18
 */
public interface ITradeMediator {

    /**
     * sell flat to all registered buyers
     *
     * @param flat
     * @return list of buyers, that corresponds to this flat
     */
    Set<FlatBuyer> sell(Flat flat);

    /**
     * search flat in registered flats
     *
     * @param buyer buyer, who wants to buy a flat
     * @return list of flats, that corresponds to this buyer
     */
    Set<Flat> buy(FlatBuyer buyer);
}
