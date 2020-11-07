package junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void div() {
        Calc calc = new Calc();
        assertEquals(calc.div(2, 1), 2);
    }
}