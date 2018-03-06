package zulus.lab4;

import org.junit.jupiter.api.Test;
import zulus.lab4.state.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by zulus on 06.03.18
 */
public class StateTest {
    Cleaner c;

    public StateTest() {
        c = new Cleaner();
    }

    @Test
    void CleanerConstructor() {
        assertThrows(IllegalArgumentException.class, () -> c.clean());
    }

    @Test
    void CleanerDeepClean() {
        c.setState(State.DEEP);
        assertEquals(c.clean(), new DeepCleaning().clean());
    }

    @Test
    void CleanerLightClean() {
        c.setState(State.LIGHT);
        assertEquals(c.clean(), new LightCleaning().clean());
    }

    @Test
    void CleanerNormalClean() {
        c.setState(State.NORMAL);
        assertEquals(c.clean(), new NormalCleaning().clean());
    }

    @Test
    void CleanerEmptyMode() {
        assertThrows(IllegalArgumentException.class, () -> c.setState(null));
    }
}
