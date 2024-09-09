import org.example.FactorialCalculator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialCalculatorTest {
    FactorialCalculator factorialCalculator = new FactorialCalculator();

    @Test
    public void factorialOfPositiveClassesTest() {
        assertEquals(factorialCalculator.calculateFactorial(1), 1);
        assertEquals(factorialCalculator.calculateFactorial(4), 24);
        assertEquals(factorialCalculator.calculateFactorial(10), 3628800);
    }

    @Test
    public void factorialOfZeroTest() {
        assertEquals(factorialCalculator.calculateFactorial(0), 1);
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