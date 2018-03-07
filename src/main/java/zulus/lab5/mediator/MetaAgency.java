package zulus.lab5.mediator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zulus on 07.03.18
 */
public class MetaAgency implements ITradeMediator {
    private HashSet<ITradeMediator> sellers;

    public boolean register(ITradeMediator seller) {
        return sellers.add(seller);
    }

    public boolean unregister(ITradeMediator seller) {
        return sellers.remove(seller);
    }

    public MetaAgency() {
        this.sellers = new HashSet<>();
    }

    @Override
    public Set<FlatBuyer> sell(Flat flat) {
        Set<FlatBuyer> buyers = sellers
                .stream()
                .flatMap((ITradeMediator seller) -> seller.sell(flat).stream())
                .collect(Collectors.toSet());
        return buyers;
    }

    @Override
    public Set<Flat> buy(FlatBuyer buyer) {
        Set<Flat> flats = sellers
                .stream()
                .flatMap((ITradeMediator seller) -> seller.buy(buyer).stream())
                .collect(Collectors.toSet());
        return flats;
    }
}
