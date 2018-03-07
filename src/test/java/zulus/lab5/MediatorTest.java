package zulus.lab5;

import org.junit.jupiter.api.Test;
import zulus.lab5.mediator.*;

import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by zulus on 06.03.18
 */
public class MediatorTest {
    double _delta = 1e-6;


    @Test
    void metaAgency_add() {
        MetaAgency MA = new MetaAgency();
        Agency A = new Agency(MA);
        assertFalse(MA.register(A));
    }

    @Test
    void metaAgency_unregister() {
        MetaAgency MA = new MetaAgency();
        Agency A = new Agency(MA);
        assertTrue(MA.unregister(A));
        assertFalse(MA.unregister(new Agency()));
    }

    @Test
    void seller_constructor_valid() {
        String name = "Дядько Лев";
        FlatSeller s = new FlatSeller(name);
        assertEquals(s.getName(), name);
    }

    @Test
    void buyer_constructor_valid() {
        String name = "Олесь";
        int requiredRooms = 10;
        double cash = 100;
        FlatBuyer B = new FlatBuyer(name, requiredRooms, cash);
        assertEquals(B.getName(), name);
        assertEquals(B.getMaxCost(), cash, _delta);
        assertEquals(B.getRooms(), requiredRooms);
    }

    @Test
    void buyer_constructor_invalidRooms() {
        String name = "Олесь";
        double cash = 100;
        assertThrows(IllegalArgumentException.class, () -> new FlatBuyer(name, -1, cash));
        assertThrows(IllegalArgumentException.class, () -> new FlatBuyer(name, 0, cash));

    }

    @Test
    void buyer_constructor_invalidCash() {
        String name = "Олесь";
        int requiredRooms = 1;
        assertThrows(IllegalArgumentException.class, () -> new FlatBuyer(name, requiredRooms, 0));
        assertThrows(IllegalArgumentException.class, () -> new FlatBuyer(name, requiredRooms, -1));
    }

    @Test
    void flat_constructor_valid() {
        FlatSeller seller = new FlatSeller("Ванька");
        int rooms = 5;
        double cost = 1e6;
        Flat f = new Flat(rooms, cost, seller);
        assertEquals(f.getCost(), cost, _delta);
        assertEquals(f.getRooms(), rooms);
        assertEquals(f.getSeller(), seller);
    }

    @Test
    void flat_constructor_invalidCost() {
        FlatSeller seller = new FlatSeller("Ванька");
        int rooms = 5;
        double cost = -1e6;
        assertThrows(IllegalArgumentException.class, () -> new Flat(rooms, cost, seller));
    }

    @Test
    void flat_constructor_invalidRooms() {
        FlatSeller seller = new FlatSeller("Ванька");
        int rooms = -5;
        double cost = 1e6;
        assertThrows(IllegalArgumentException.class, () -> new Flat(rooms, cost, seller));
    }

    @Test
    void flat_constructor_emptySeller() {
        FlatSeller seller = null;
        int rooms = 5;
        double cost = 1e6;
        assertThrows(IllegalArgumentException.class, () -> new Flat(rooms, cost, seller));
    }

    @Test
    void agency_sell_newFlat() {
        Agency A = new Agency();
        Set list = A.sell(new Flat(10, 1, new FlatSeller("Lloyd")));
        assertTrue(list.isEmpty());
    }

    @Test
    void agency_buy_newFlat() {
        Agency A = new Agency();
        Set list = A.buy(new FlatBuyer("Гришка", 10, 1));
        assertTrue(list.isEmpty());
    }

    @Test
    void agency_register_flatAlreadyExist() {
        Agency A = new Agency();
        Flat F = new Flat(10, 1, new FlatSeller("Lloyd"));
        A.register(F);
        assertFalse(A.register(F));
    }

    @Test
    void agency_register_buyerAlreadyExist() {
        Agency A = new Agency();
        FlatBuyer B = new FlatBuyer("Гришка", 10, 1);
        A.register(B);
        assertFalse(A.register(B));
    }

    @Test
    void agency_unregister_noFlatExist() {
        Agency A = new Agency();
        Flat F = new Flat(10, 1, new FlatSeller("Lloyd"));
        assertFalse(A.unregister(F));
    }

    @Test
    void agency_register_noBuyerExist() {
        Agency A = new Agency();
        FlatBuyer B = new FlatBuyer("Гришка", 10, 1);
        assertFalse(A.unregister(B));
    }

    @Test
    void agency_buy_noFlatIsCorresponding() {
        Agency A = new Agency();
        FlatSeller S = new FlatSeller("Rick");
        A.sell(new Flat(10, 2e1, S));
        A.sell(new Flat(15, 2e6, S));
        A.sell(new Flat(3, 1e5, S));
        FlatBuyer B = new FlatBuyer("Гришка", 10, 1);
        assertTrue(A.buy(B).isEmpty());
    }

    @Test
    void agency_sell_noBuyerIsCorresponding() {
        Agency A = new Agency();
        FlatSeller S = new FlatSeller("Rick");
        A.buy(new FlatBuyer("Chuck", 10, 2e1));
        A.buy(new FlatBuyer("Rick", 10, 2e1));
        A.buy(new FlatBuyer("Dick", 10, 2e1));
        assertTrue(A.sell(new Flat(3, 1e5, S)).isEmpty());
    }


    @Test
    void agency_sell_normal() {
        Agency A = new Agency();
        FlatSeller S = new FlatSeller("Rick");
        Flat F1 = new Flat(1, 1e5, S);
        Flat F2 = new Flat(2, 1e5, S);
        Flat F3 = new Flat(3, 1e5, S);
        Flat F4 = new Flat(3, 1e4, S);
        FlatBuyer B = new FlatBuyer("Ron", 3, 1e6);
        A.register(F1);
        A.register(F2);
        A.register(F3);
        A.register(F4);
        Set flats = A.buy(B);
        assertEquals(flats.size(), 2);
        assertTrue(flats.contains(F3));
        assertTrue(flats.contains(F4));
    }

    @Test
    void agency_sell_addFlatWithExistingBuyer() {
        Agency A = new Agency();
        FlatSeller S = new FlatSeller("Rick");
        Flat F1 = new Flat(1, 1e5, S);
        Flat F2 = new Flat(3, 1e5, S);
        Flat F3 = new Flat(3, 1e4, S);
        FlatBuyer B1 = new FlatBuyer("Ron", 3, 1e6);
        FlatBuyer B2 = new FlatBuyer("John", 3, 1e7);
        FlatBuyer B3 = new FlatBuyer("Willy", 4, 1e7);
        A.register(F1);
        A.register(F2);
        A.register(B1);
        A.register(B2);
        A.register(B3);
        Set buyers = A.sell(F3);
        assertEquals(buyers.size(), 2);
        assertTrue(buyers.contains(B1));
        assertTrue(buyers.contains(B2));
        assertFalse(buyers.contains(B3));
    }

    @Test
    void agency_buyEnywhere() {
        MetaAgency ma = new MetaAgency();
        Agency a1 = new Agency(ma);
        Agency a2 = new Agency(ma);
        a1.register(new Flat(10, 1e4, new FlatSeller("Jack")));
        a2.register(new Flat(10, 1e5, new FlatSeller("Ron")));
        a2.register(new Flat(10, 1e7, new FlatSeller("Umi Chu")));
        a2.register(new Flat(1, 1e7, new FlatSeller("Lao Dzun")));
        Set set = a1.buyEnywhere(new FlatBuyer("Jimmy", 10, 1e10));
        assertEquals(set.size(), 3);
    }

    @Test
    void agency_sellEnywhere() {
        MetaAgency ma = new MetaAgency();
        Agency a1 = new Agency(ma);
        Agency a2 = new Agency(ma);
        a1.register(new FlatBuyer("Ron", 10, 1e5));
        a1.register(new FlatBuyer("Chuck", 10, 1e3));
        a2.register(new FlatBuyer("Hank", 10, 1e5));
        a1.register(new FlatBuyer("Ron", 2, 1e10));
        a2.register(new FlatBuyer("Ron", 10, 1e2));
        Set set = a1.sellEnywhere(new Flat(10, 1e3, new FlatSeller("Willy")));
        assertEquals(set.size(), 3);
    }
}
