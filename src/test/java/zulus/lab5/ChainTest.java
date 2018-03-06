package zulus.lab5;

import org.junit.jupiter.api.Test;
import zulus.lab5.chainOfResponsibility.Client;
import zulus.lab5.chainOfResponsibility.Friend;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by zulus on 06.03.18
 */
public class ChainTest {
    double _delta = 1e-6;

    @Test
    void FriendConstructor() {
        String name = "Luke";
        double cash = 1000;
        Friend f1 = new Friend(name, cash);
        assertEquals(f1.getMoney(), cash, _delta);
        assertEquals(f1.getName(), name);
    }

    @Test
    void ClientConstructor() {
        String name = "Luke";
        double cash = 1000;
        Client c1 = new Client(name, cash);
        assertEquals(c1.getMoney(), cash, _delta);
        assertEquals(c1.getName(), name);
    }

    @Test
    void ChainTest() {
        Friend f1 = new Friend("Sam", 10);
        Friend f2 = new Friend("Ron", 50);
        Client c = new Client("Eugine", 42);
        c.setSuccessor(f1);
        f1.setSuccessor(f2);
        assertEquals(c.getSuccessor(), f1);
        assertEquals(c.getSuccessor().getSuccessor(), f2);
    }

    Client createClient() {
        Friend f1 = new Friend("Sam", 50);
        Friend f2 = new Friend("Ron", 100);
        Client c = new Client("Eugine", 10);
        c.setSuccessor(f1);
        f1.setSuccessor(f2);
        return c;
    }

    @Test
    void clientPayByHimself() {
        Client c = createClient();
        assertTrue(c.askForMoney(c.getMoney() / 2));
    }

    @Test
    void clientPayBy1Friend() {
        Client c = createClient();
        assertTrue(c.askForMoney(c.getMoney() * 2));
    }

    @Test
    void clientPayBy2Friend() {
        Client c = createClient();
        assertTrue(c.askForMoney(c.getMoney() * 10));
    }

    @Test
    void clientCannotPay() {
        Client c = createClient();
        assertFalse(c.askForMoney(1e6));
    }
}
