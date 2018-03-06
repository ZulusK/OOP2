package zulus.lab4;

import org.junit.jupiter.api.Test;
import zulus.lab4.strategy.Client;
import zulus.lab4.strategy.discounts.BasicDiscount;
import zulus.lab4.strategy.discounts.ClientDiscount;
import zulus.lab4.strategy.discounts.VIPDiscount;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by zulus on 06.03.18
 */
public class StrategyTest {
    @Test
    void Client_Creation_Normal() {
        String name = "Sam";
        Client c = new Client(name);
        assertEquals(c.getName(), name);
        assertNull(c.getDiscount());
    }

    @Test
    void VIPDiscount_using() {
        String name = "Sam";
        Client c = new Client(name);
        VIPDiscount discount = new VIPDiscount();
        c.setDiscount(discount);
        assertEquals(c.getDiscount(), discount);
        assertTrue(c.pay().contains(discount.toString()));
    }

    @Test
    void BasicDiscount_using() {
        String name = "Sam";
        Client c = new Client(name);
        BasicDiscount discount = new BasicDiscount();
        c.setDiscount(discount);
        assertEquals(c.getDiscount(), discount);
        assertTrue(c.pay().contains(discount.toString()));
    }

    @Test
    void ClientDiscount_using() {
        String name = "Sam";
        Client c = new Client(name);
        ClientDiscount discount = new ClientDiscount();
        c.setDiscount(discount);
        assertEquals(c.getDiscount(), discount);
        assertTrue(c.pay().contains(discount.toString()));
    }

}
