import org.assertj.core.api.SoftAssertions;
import org.example.FactorialCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
    FactorialCalculator factorialCalculator = new FactorialCalculator();

    @Test
    public void factorialOfPositiveClassesTest() {
        BigInteger[] expectedValues = {BigInteger.ONE,
                new BigInteger("24"),
                new BigInteger("3628800")};
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(factorialCalculator.calculateFactorial(1)).isEqualTo(expectedValues[0]);
        softly.assertThat(factorialCalculator.calculateFactorial(3)).isEqualTo(expectedValues[1]);
        softly.assertThat(factorialCalculator.calculateFactorial(10)).isEqualTo(expectedValues[2]);
        softly.assertAll();
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
    public void factorialOfBiggerThanOneHundredValueTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCalculator.calculateFactorial(101));
    }

    @Test
    public void factorialOfMaxValueTest() {
        assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
                factorialCalculator.calculateFactorial(100));
    }
}