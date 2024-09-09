import org.example.FactorialCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    FactorialCalculator factorialCalculator = new FactorialCalculator();

    @Test
    public void factorialOfPositiveClassesTest() {
        int[] expectedValues = {1, 24, 3628800};
        assertAll("numbers",
                () -> assertEquals(expectedValues[0], factorialCalculator.calculateFactorial(1)),
                () -> assertEquals(expectedValues[1], factorialCalculator.calculateFactorial(4)),
                () -> assertEquals(expectedValues[2], factorialCalculator.calculateFactorial(10))
        );
    }

    @Test
    public void factorialOfZeroTest() {
        assertEquals(1, factorialCalculator.calculateFactorial(0));
    }

    @Test
    public void factorialOfNegativeValueTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCalculator.calculateFactorial(-1));
    }

    @Test
    public void factorialOfBiggerThanTwentyValueTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCalculator.calculateFactorial(21));
    }

    @Test
    public void factorialOfMaxValueTest() {
        assertEquals(new Long("2432902008176640000"), factorialCalculator.calculateFactorial(20));
    }
}