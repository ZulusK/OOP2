package zulus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void sum() {
        assertEquals(Calc.sum(1,2),3);
    }
}