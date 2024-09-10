import org.example.FactorialCalculator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialCalculatorTest {
   private  FactorialCalculator factorialCalculator;

    @BeforeClass
    public void createCalculatorInstance(){
        factorialCalculator = new FactorialCalculator();
    }

    @Test
    public void factorialOfPositiveTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(factorialCalculator.calculateFactorial(1), BigInteger.ONE);
        softAssert.assertEquals(factorialCalculator.calculateFactorial(4), new BigInteger("24"));
        softAssert.assertEquals(factorialCalculator.calculateFactorial(10), new BigInteger("3628800"));
        softAssert.assertEquals(factorialCalculator.calculateFactorial(30), new BigInteger("265252859812191058636308480000000"));
        softAssert.assertEquals(factorialCalculator.calculateFactorial(60), new BigInteger("8320987112741390144276341183223364380754172606361245952449277696409600000000000000"));
        softAssert.assertEquals(factorialCalculator.calculateFactorial(80), new BigInteger("71569457046263802294811533723186532165584657342365752577109445058227039255480148842668944867280814080000000000000000000"));
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
        assertEquals(factorialCalculator.calculateFactorial(100),
                new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000")
        );
    }
}