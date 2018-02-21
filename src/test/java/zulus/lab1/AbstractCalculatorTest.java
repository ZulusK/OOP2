package zulus.lab1;

import org.junit.jupiter.api.Test;
import zulus.lab1.calc.AbstractCalculator;
import zulus.lab1.calc.EngineerCalculator;
import zulus.lab1.calc.InvalidCalcModeException;
import zulus.lab1.calc.SimpleCalculator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zulus on 21.02.18
 */
class AbstractCalculatorTest {
    private double _delta = 1e-6;
    private AbstractCalculator simple;
    private AbstractCalculator engineer;

    AbstractCalculatorTest() {
        this.simple = new AbstractCalculator(new SimpleCalculator());
        this.engineer = new AbstractCalculator(new EngineerCalculator());
    }

    @Test
    void getCaluclator() {
        assertTrue(simple.getCalculator() instanceof SimpleCalculator);
        assertTrue(engineer.getCalculator() instanceof EngineerCalculator);
    }

    @Test
    void setCalculator() {
        assertThrows(IllegalArgumentException.class, () -> {
            simple.setCalculator(null);
        });
        SimpleCalculator SC = new SimpleCalculator();
        EngineerCalculator EC = new EngineerCalculator();
        AbstractCalculator AC = new AbstractCalculator(SC);
        AC.setCalculator(EC);
        assertAll(
                () -> {
                    assertTrue(AC.isInEngineerMode());
                },
                () -> {
                    assertEquals(AC.getCalculator(), EC);
                });
    }

    @Test
    void testMode() {
        assertTrue(engineer.isInEngineerMode());
        assertFalse(simple.isInEngineerMode());
    }

    @Test
    void sumSimple() {
        int A = 5;
        int B = 3;
        assertEquals(simple.sum(A, B), A + B);
    }

    @Test
    void sumEngineer() {
        int A = 5;
        int B = 3;
        assertEquals(engineer.sum(A, B), A + B);
    }

    @Test
    void multiplyEngineer() {
        int A = 5;
        int B = 3;
        assertEquals(engineer.multiply(A, B), A * B);
    }

    @Test
    void multiplySimple() {
        int A = 5;
        int B = 3;
        assertEquals(simple.multiply(A, B), A * B);
    }

    @Test
    void divSimple() {
        double A = 5;
        double B = 3;
        assertEquals(simple.div(A, B), A / B, _delta);
    }

    @Test
    void divEngineer() {
        double A = 5;
        double B = 3;
        assertEquals(engineer.div(A, B), A / B, _delta);
    }

    @Test
    void simpleUnsupportedOperations() {
        SimpleCalculator s = new SimpleCalculator();
        assertAll(
                () -> assertThrows(UnsupportedOperationException.class, () -> s.sqrt(10)),
                () -> assertThrows(UnsupportedOperationException.class, () -> s.divByModulo(10, 1)),
                () -> assertThrows(UnsupportedOperationException.class, () -> s.pow(10, 3))
        );
    }

    @Test
    void subtractSimple() {
        int A = 5;
        int B = 3;
        assertEquals(simple.subtract(A, B), A - B);
    }

    @Test
    void subtractEngineer() {
        int A = 5;
        int B = 3;
        assertEquals(engineer.subtract(A, B), A - B);
    }

    @Test
    void sqrtSimple() {
        double A = 100;
        assertThrows(InvalidCalcModeException.class, () -> {
            simple.sqrt(A);
        });

    }

    @Test
    void sqrtEngineer() {
        double A = 100;
        assertEquals(engineer.sqrt(A), Math.sqrt(A), _delta);
    }

    @Test
    void divByModuloSimple() {
        int A = 100;
        int B = 10;
        assertThrows(InvalidCalcModeException.class, () -> {
            simple.divByModulo(A, B);
        });
    }

    @Test
    void divByModuloEngineer() {
        int A = 100;
        int B = 10;
        assertEquals(engineer.divByModulo(A, B), A % B);
    }

    @Test
    void powSimple() {
        int A = 100;
        int B = 10;
        assertThrows(InvalidCalcModeException.class, () -> {
            simple.pow(A, B);
        });
    }

    @Test
    void powEngineer() {
        int A = 100;
        int B = 10;
        assertEquals(engineer.pow(A, B), Math.pow(A, B), _delta);
    }
}