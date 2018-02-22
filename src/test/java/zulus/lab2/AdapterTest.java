package zulus.lab2;

import org.junit.jupiter.api.Test;
import zulus.lab2.adapter.AdultWebsite;
import zulus.lab2.adapter.JuniorWebsite;
import zulus.lab2.adapter.Visitor;
import zulus.lab2.adapter.Website;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by zulus on 22.02.18
 */
public class AdapterTest {
    private Website W;

    public AdapterTest() {
        W = new Website();
    }

    @Test
    void VisitorConstructor() {
        String name = "Sam";
        int age1 = 15;
        int age2 = 0;
        Visitor v1 = new Visitor(name, age1);
        Visitor v2 = new Visitor(name, age2);
        assertEquals(v1.getName(), name);
        assertEquals(v1.getAge(), age1);
        assertEquals(v2.getAge(), age2);
        assertThrows(IllegalArgumentException.class, () -> new Visitor(name, -1));
    }

    @Test
    void WebsiteSmartJunior() {
        String name = "Sam";
        int age = 15;
        Visitor v = new Visitor(name, age);
        assertNotNull(W.enterToService(v));
        assertThrows(IllegalArgumentException.class, () -> W.enterToService(null));
        assertTrue(W.enterToService(v).toLowerCase().startsWith("привет, "));
    }

    @Test
    void WebsiteJunior() {
        String name = "Sam";
        int age = 15;
        JuniorWebsite JW = new JuniorWebsite();
        assertNotNull(JW.enterToService(new Visitor(name, W.ADULT_AGE - 1)));
        assertNotNull(JW.enterToService(new Visitor(name, W.ADULT_AGE)));
        assertNotNull(JW.enterToService(new Visitor(name, W.ADULT_AGE + 1)));
        assertThrows(IllegalArgumentException.class, () -> JW.enterToService(null));
        assertTrue(JW.enterToService(new Visitor(name, W.ADULT_AGE - 1)).toLowerCase().startsWith("привет, "));
        assertTrue(JW.enterToService(new Visitor(name, W.ADULT_AGE)).toLowerCase().startsWith("привет, "));
        assertTrue(JW.enterToService(new Visitor(name, W.ADULT_AGE + 1)).toLowerCase().startsWith("привет, "));
    }

    void WebsiteAdult() {
        String name = "Sam";
        int age = 15;
        AdultWebsite AW = new AdultWebsite();
        assertNotNull(AW.enterToService(new Visitor(name, W.ADULT_AGE - 1)));
        assertNotNull(AW.enterToService(new Visitor(name, W.ADULT_AGE)));
        assertNotNull(AW.enterToService(new Visitor(name, W.ADULT_AGE + 1)));
        assertThrows(IllegalArgumentException.class, () -> AW.enterToService(null));
        assertTrue(AW.enterToService(new Visitor(name, W.ADULT_AGE - 1)).toLowerCase().startsWith("привет, "));
        assertTrue(AW.enterToService(new Visitor(name, W.ADULT_AGE)).toLowerCase().startsWith("привет, "));
        assertTrue(AW.enterToService(new Visitor(name, W.ADULT_AGE + 1)).toLowerCase().startsWith("привет, "));
    }

    @Test
    void WebsiteSmartAdult() {
        String name = "Sam";
        int age = W.ADULT_AGE + 1;
        Visitor v = new Visitor(name, age);
        assertNotNull(W.enterToService(v));
        assertThrows(IllegalArgumentException.class, () -> W.enterToService(null));
        assertTrue(W.enterToService(v).toLowerCase().startsWith("добрый день, "));
    }

    @Test
    void WebsiteSmartMiddle() {
        String name = "Sam";
        int age = W.ADULT_AGE;
        Visitor v = new Visitor(name, age);
        assertNotNull(W.enterToService(v));
        assertTrue(W.enterToService(v).toLowerCase().startsWith("добрый день, "));
    }
}
