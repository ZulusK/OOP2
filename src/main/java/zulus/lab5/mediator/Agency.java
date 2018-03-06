package zulus.lab5.mediator;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zulus on 06.03.18
 */
public class Agency implements TradeMediator {
    private HashSet<Flat> flats;
    private HashSet<Buyer> buyers;

    public Agency() {
        this.flats = new HashSet<>();
        this.buyers = new HashSet<>();
    }

    private boolean register(Flat flat) {
        return flats.add(flat);
    }

    private boolean register(Buyer buyer) {
        return buyers.add(buyer);
    }

    private List<Buyer> offer(Flat flat) {
        List<Buyer> selectedBuyers = buyers
                .stream()
                .filter((Buyer buyer) -> buyer.correspondsTo(flat))
                .collect(Collectors.toList());
        return selectedBuyers;
    }

    @Override
    public List<Buyer> sell(Flat flat) {
        if (flats.add(flat)) {
            return offer(flat);
        } else {
            throw new IllegalArgumentException("This flat is already registered");
        }
    }

    public List<Flat> request(Buyer buyer) {
        // исследовать все доступные квартиры
        // в данном агенстве на соответствие
        List<Flat> selectedFlats = flats
                .stream()
                .filter((Flat flat) -> buyer.correspondsTo(flat))
                .collect(Collectors.toList());
        return selectedFlats;
    }

    @Override
    public List<Flat> buy(Buyer buyer) {
        // добавить в список покупателей
        if (buyers.add(buyer)) {
            return request(buyer);
        } else {
            throw new IllegalArgumentException("This buyer is already registered");
        }
    }
}
