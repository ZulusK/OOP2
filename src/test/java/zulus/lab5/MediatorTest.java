package zulus.lab5;

import org.junit.jupiter.api.Test;
import zulus.lab5.mediator.Agency;
import zulus.lab5.mediator.Buyer;
import zulus.lab5.mediator.Flat;
import zulus.lab5.mediator.Seller;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by zulus on 06.03.18
 */
public class MediatorTest {
    double _delta = 1e-6;

    @Test
    void seller_constructor_valid() {
        String name = "Дядько Лев";
        Seller s = new Seller(name);
        assertEquals(s.getName(), name);
    }

    @Test
    void buyer_constructor_valid() {
        String name = "Олесь";
        int requiredRooms = 10;
        double cash = 100;
        Buyer B = new Buyer(name, requiredRooms, cash);
        assertEquals(B.getName(), name);
        assertEquals(B.getMaxCost(), cash, _delta);
        assertEquals(B.getRooms(), requiredRooms);
    }

    @Test
    void buyer_constructor_invalidRooms() {
        String name = "Олесь";
        double cash = 100;
        assertThrows(IllegalArgumentException.class, () -> new Buyer(name, -1, cash));
        assertThrows(IllegalArgumentException.class, () -> new Buyer(name, 0, cash));

    }

    @Test
    void buyer_constructor_invalidCash() {
        String name = "Олесь";
        int requiredRooms = 1;
        assertThrows(IllegalArgumentException.class, () -> new Buyer(name, requiredRooms, 0));
        assertThrows(IllegalArgumentException.class, () -> new Buyer(name, requiredRooms, -1));
    }

    @Test
    void flat_constructor_valid() {
        Seller seller = new Seller("Ванька");
        int rooms = 5;
        double cost = 1e6;
        Flat f = new Flat(rooms, cost, seller);
        assertEquals(f.getCost(), cost, _delta);
        assertEquals(f.getRooms(), rooms);
        assertEquals(f.getSeller(), seller);
    }

    @Test
    void flat_constructor_invalidCost() {
        Seller seller = new Seller("Ванька");
        int rooms = 5;
        double cost = -1e6;
        assertThrows(IllegalArgumentException.class, () -> new Flat(rooms, cost, seller));
    }

    @Test
    void flat_constructor_invalidRooms() {
        Seller seller = new Seller("Ванька");
        int rooms = -5;
        double cost = 1e6;
        assertThrows(IllegalArgumentException.class, () -> new Flat(rooms, cost, seller));
    }

    @Test
    void flat_constructor_emptySeller() {
        Seller seller = null;
        int rooms = 5;
        double cost = 1e6;
        assertThrows(IllegalArgumentException.class, () -> new Flat(rooms, cost, seller));
    }

    @Test
    void agency_sell_newFlat() {
        Agency A = new Agency();
        List list = A.sell(new Flat(10, 1, new Seller("Lloyd")));
        assertTrue(list.isEmpty());
    }

    @Test
    void agency_buy_newFlat() {
        Agency A = new Agency();
        List list = A.buy(new Buyer("Гришка", 10, 1));
        assertTrue(list.isEmpty());
    }

    @Test
    void agency_sell_flatAlreadyExist() {
        Agency A = new Agency();
        Flat F = new Flat(10, 1, new Seller("Lloyd"));
        A.sell(F);
        assertThrows(IllegalArgumentException.class, () -> A.sell(F));
    }

    @Test
    void agency_buy_buyerAlreadyExist() {
        Agency A = new Agency();
        Buyer B = new Buyer("Гришка", 10, 1);
        A.buy(B);
        assertThrows(IllegalArgumentException.class, () -> A.buy(B));
    }

    @Test
    void agency_buy_noFlatIsCorresponding() {
        Agency A = new Agency();
        Seller S = new Seller("Rick");
        A.sell(new Flat(10, 2e1, S));
        A.sell(new Flat(15, 2e6, S));
        A.sell(new Flat(3, 1e5, S));
        Buyer B = new Buyer("Гришка", 10, 1);
        assertTrue(A.buy(B).isEmpty());
    }

    @Test
    void agency_sell_noBuyerIsCorresponding() {
        Agency A = new Agency();
        Seller S = new Seller("Rick");
        A.buy(new Buyer("Chuck", 10, 2e1));
        A.buy(new Buyer("Rick", 10, 2e1));
        A.buy(new Buyer("Dick", 10, 2e1));
        assertTrue(A.sell(new Flat(3, 1e5, S)).isEmpty());
    }


    @Test
    void agency_sell_normal() {
        Agency A = new Agency();
        Seller S = new Seller("Rick");
        Flat F1 = new Flat(1, 1e5, S);
        Flat F2 = new Flat(2, 1e5, S);
        Flat F3 = new Flat(3, 1e5, S);
        Flat F4 = new Flat(3, 1e4, S);
        Buyer B = new Buyer("Ron", 3, 1e6);
        A.sell(F1);
        A.sell(F2);
        A.sell(F3);
        A.sell(F4);
        List flats = A.buy(B);
        assertEquals(flats.size(), 2);
        assertTrue(flats.contains(F3));
        assertTrue(flats.contains(F4));
        assertThrows(IllegalArgumentException.class, () -> A.buy(B));
    }
}
