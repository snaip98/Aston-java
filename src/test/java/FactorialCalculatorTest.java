import org.example.FactorialCalculator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialCalculatorTest {
    FactorialCalculator factorialCalculator = new FactorialCalculator();

    @Test
    public void factorialOfPositiveClassesTest() {
        BigInteger[] expectedValues = new BigInteger[]{BigInteger.ONE,
                new BigInteger("24"),
                new BigInteger("3628800")};
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(factorialCalculator.calculateFactorial(1), expectedValues[0]);
        softAssert.assertEquals(factorialCalculator.calculateFactorial(4), expectedValues[1]);
        softAssert.assertEquals(factorialCalculator.calculateFactorial(10), expectedValues[2]);
        softAssert.assertAll();
    }

    @Test
    public void factorialOfZeroTest() {
        assertEquals(factorialCalculator.calculateFactorial(0), BigInteger.ONE);
    }

    @Test
    public void factorialOfNegativeValueTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCalculator.calculateFactorial(-1));
    }

    @Test
    public void factorialOfBiggerThanMaxValueTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCalculator.calculateFactorial(101));
    }

    @Test
    public void factorialOfMaxValueTest() {
        assertEquals(new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"),
                factorialCalculator.calculateFactorial(100));
    }
}