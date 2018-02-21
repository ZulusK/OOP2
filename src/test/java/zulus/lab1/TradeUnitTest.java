package zulus.lab1;


import org.junit.jupiter.api.Test;
import zulus.lab1.beutyStaff.Manager;
import zulus.lab1.beutyStaff.Product;
import zulus.lab1.beutyStaff.Seller;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zulus on 21.02.18
 */
public class TradeUnitTest {
    double _delta = 1e-6;

    @Test
    void constructorProduct() {
        double minCost = 100;
        double maxCost = 200;
        String name = "Pen";
        Product product = new Product(minCost, maxCost, name);
        assertAll(
                () -> assertEquals(product.getMaxCost(), maxCost, _delta),
                () -> assertEquals(product.getMinCost(), minCost, _delta),
                () -> assertEquals(product.getName(), name));
    }

    @Test
    void constructorProductWithInvalidCosts() {
        double minCost = 200;
        double maxCost = 100;
        String name = "Pen";
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = new Product(minCost, maxCost, name);
        });
    }

    @Test
    void constructorManager() {
        double extraCharge = 0.15;
        String name = "Sam";
        Manager M = new Manager(name, extraCharge);
        assertEquals(M.getExtraCharge(), extraCharge, _delta);
        assertEquals(M.getName(), name);
    }

    @Test
    void constructorManagerWithInvalidCharge() {
        double extraCharge = -0.15;
        String name = "Sam";
        assertThrows(IllegalArgumentException.class, () -> {
            Manager M = new Manager(name, extraCharge);
        });
    }

    @Test
    void constructorSeller() {
        double extraCharge = 0.15;
        String name = "Sam";
        Seller S = new Seller(name, extraCharge);
        assertEquals(S.getExtraCharge(), extraCharge, _delta);
        assertEquals(S.getName(), name);
    }

    @Test
    void SellerUnsupportedOperations() {
        Seller S1 = new Seller("Bill", 1);
        Seller S2 = new Seller("Young Tau", 2);
        assertAll(
                () -> assertThrows(UnsupportedOperationException.class, () -> S1.add((S2))),
                () -> assertThrows(UnsupportedOperationException.class, () -> S1.remove((S2)))
        );
    }

    @Test
    void constructorSellerWithInvalidCharge() {
        double extraCharge = -0.15;
        String name = "Sam";
        assertThrows(IllegalArgumentException.class, () -> {
            Seller S = new Seller(name, extraCharge);
        });
    }

    @Test
    void ManagerAddEmployee() {
        Manager M = new Manager("Victor", 1);
        Seller S1 = new Seller("Rick", 2);
        Seller S2 = new Seller("Chuck", 2);
        assertTrue(M.add(S1));
        assertTrue(M.add(S2));
        assertFalse(M.add(S1));
        assertThrows(IllegalArgumentException.class, () -> M.add(null));
        assertThrows(IllegalArgumentException.class, () -> M.add(M));
    }

    @Test
    void ManagerRemoveEmployee() {
        Manager M = new Manager("Victor", 1);
        Seller S1 = new Seller("Rick", 2);
        Seller S2 = new Seller("Chuck", 2);
        M.add(S1);
        M.add(S2);
        assertTrue(M.remove(S1));
        assertFalse(M.remove(S1));
        assertThrows(IllegalArgumentException.class, () -> M.remove(null));
    }

    @Test
    void ManagerSellProduct() {
        Manager M = new Manager("Victor", 0.15);
        Product P = new Product(100, 200, "Book");
        assertFalse(M.sell(P));
        M.add(new Seller("Bill", 0.03));
        assertTrue(M.sell(P));
        assertThrows(IllegalArgumentException.class, () -> M.sell(null));
    }

    @Test
    void SellerSellProduct() {
        Seller S = new Seller("Victor", 0.15);
        Product P = new Product(100, 200, "Book");
        System.out.println("=========================================================");
        assertTrue(S.sell(P));
        assertThrows(IllegalArgumentException.class, () -> S.sell(null));
    }

    @Test
    void NetworkOfTraderSellProduct() {
        Product P = new Product(100, 1000, "PC");
        Manager MainM = new Manager("Harry", 0.1);
        Manager subM1 = new Manager("Kent", 0.25);
        Manager subM2 = new Manager("Lucia", 0.25);
        Seller s1 = new Seller("Dominic", 0.4);
        Seller s2 = new Seller("Ron", 0.35);
        Seller s3 = new Seller("Willy", 0.5);
        MainM.add(subM1);
        MainM.add(subM2);
        MainM.add(s1);
        subM1.add(s2);
        subM1.add(s3);
        System.out.println("=========================================================");
        assertTrue(MainM.sell(P));
    }
}
