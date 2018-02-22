package zulus.lab2;

import org.junit.jupiter.api.Test;
import zulus.lab2.countingHouse.Client;
import zulus.lab2.countingHouse.CountingHouse;
import zulus.lab2.countingHouse.CountingHouseGuard;
import zulus.lab2.countingHouse.OperationCannotBePerformedException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zulus on 22.02.18
 */
public class ProxyTesx {
    CountingHouse CH;
    CountingHouseGuard CHG;
    double _delta = 1e-6;

    public ProxyTesx() {
        this.CH = new CountingHouse("Privat bank");
        this.CHG = new CountingHouseGuard(CH);
    }

    @Test
    void TestConstructorCH() {
        String name = "KPI";
        CountingHouse ch = new CountingHouse(name);
        assertEquals(ch.getName(), name);
    }

    @Test
    void TestConstructorCHG() {
        String name = "KPI";
        CountingHouse ch = new CountingHouse(name);
        CountingHouseGuard chg = new CountingHouseGuard(ch);
        assertEquals(chg.getCountinghouse(), ch);
        assertThrows(IllegalArgumentException.class, () -> new CountingHouseGuard(null));
    }

    @Test
    void TestConstructorClient() {
        String name = "BIll";
        double cash = 100.5;
        Client C = new Client(name, cash);
        assertEquals(C.getName(), name);
        assertEquals(C.getMoney(), cash);
        assertThrows(IllegalArgumentException.class, () -> new Client(name, -1));
    }

    @Test
    void TestClientCanPay() {
        String name = "BIll";
        double cash = 100.5;
        Client C = new Client(name, cash);
        assertTrue(C.canPay(cash - 1));
        assertFalse(C.canPay(cash + 1));
        assertThrows(IllegalArgumentException.class, () -> C.canPay(-5));
    }

    @Test
    void TestClientPay() {
        String name = "BIll";
        double cash = 100.5;
        double cost = 5;
        Client C = new Client(name, cash);
        assertTrue(C.pay(cost));
        assertEquals(C.getMoney(), cash - cost, _delta);
        assertFalse(C.pay(cash + 1));
        assertEquals(C.getMoney(), cash - cost, _delta);
        assertThrows(IllegalArgumentException.class, () -> C.pay(-5));
    }

    @Test
    void TestGuardPay() {
        String name = "BIll";
        double cash = 100.5;
        double cost = 5;
        Client C = new Client(name, cash);
        assertNotNull(CHG.processOperation(cost, C));
        assertNotNull(CHG.processOperation(0, C));
        assertThrows(OperationCannotBePerformedException.class, () -> CHG.processOperation(cash + 1, C));
    }

    @Test
    void TestOperationCannotBePerformedException() {
        String name = "BIll";
        double cash = 100.5;
        Client C = new Client(name, cash);
        OperationCannotBePerformedException exc = assertThrows(OperationCannotBePerformedException.class, () -> CHG.processOperation(cash + 1, C));
        assertEquals(exc.getClient(), C);
        assertEquals(exc.getHouse(), CH);
        assertNotNull(exc.getDescription());
        assertNotNull(exc.toString());
    }
}
