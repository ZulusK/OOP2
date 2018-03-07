package zulus.lab5.mediator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zulus on 06.03.18
 */
public class Agency implements ITradeMediator {
    private HashSet<Flat> flats;
    private HashSet<FlatBuyer> buyers;
    private MetaAgency _metaAgency;

    public void setMetaAgency(MetaAgency metaAgency) {
        if (metaAgency == null) throw new IllegalArgumentException("Argument metaAgency must be not-null value");
        if (_metaAgency != null) _metaAgency.unregister(this);
        this._metaAgency = metaAgency;
        this._metaAgency.register(this);
    }

    public Agency(MetaAgency metaAgency) {
        setMetaAgency(metaAgency);
        this.flats = new HashSet<>();
        this.buyers = new HashSet<>();
    }

    public Agency() {
        this.flats = new HashSet<>();
        this.buyers = new HashSet<>();
    }

    public boolean register(Flat flat) {
        return flats.add(flat);
    }

    public boolean unregister(Flat flat) {
        return flats.remove(flat);
    }

    public boolean register(FlatBuyer buyer) {
        return buyers.add(buyer);
    }

    public boolean unregister(FlatBuyer buyer) {
        return buyers.remove(buyer);
    }

    private Set<FlatBuyer> offer(Flat flat) {
        Set<FlatBuyer> selectedBuyers = buyers
                .stream()
                .filter((FlatBuyer buyer) -> buyer.correspondsTo(flat))
                .collect(Collectors.toSet());
        return selectedBuyers;
    }

    @Override
    public Set<FlatBuyer> sell(Flat flat) {
//        if (!flats.contains(flat)) {
        return offer(flat);
//        } else {
//            throw new IllegalArgumentException("This flat is already registered");
//        }
    }

    public Set<Flat> request(FlatBuyer buyer) {
        // исследовать все доступные квартиры
        // в данном агенстве на соответствие
        Set<Flat> selectedFlats = flats
                .stream()
                .filter((Flat flat) -> buyer.correspondsTo(flat))
                .collect(Collectors.toSet());
        return selectedFlats;
    }

    @Override
    public Set<Flat> buy(FlatBuyer buyer) {
        // добавить в список покупателей
//        if (!buyers.contains(buyer)) {
        return request(buyer);
//        } else {
//            throw new IllegalArgumentException("This buyer is already registered");
//        }
    }

    public Set<FlatBuyer> sellEnywhere(Flat flat) {
        if (_metaAgency == null) return offer(flat);
        return _metaAgency.sell(flat);
    }

    public Set<Flat> buyEnywhere(FlatBuyer buyer) {
        if (_metaAgency == null) return request(buyer);
        return _metaAgency.buy(buyer);
    }

}
