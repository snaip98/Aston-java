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
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(factorialCalculator.calculateFactorial(1)).isEqualTo(BigInteger.ONE);
        softAssertions.assertThat(factorialCalculator.calculateFactorial(4)).isEqualTo(new BigInteger("24"));
        softAssertions.assertThat(factorialCalculator.calculateFactorial(10)).isEqualTo(new BigInteger("3628800"));
        softAssertions.assertThat(factorialCalculator.calculateFactorial(30)).isEqualTo(new BigInteger("265252859812191058636308480000000"));
        softAssertions.assertThat(factorialCalculator.calculateFactorial(60)).isEqualTo(new BigInteger("8320987112741390144276341183223364380754172606361245952449277696409600000000000000"));
        softAssertions.assertThat(factorialCalculator.calculateFactorial(80)).isEqualTo(new BigInteger("71569457046263802294811533723186532165584657342365752577109445058227039255480148842668944867280814080000000000000000000"));
        softAssertions.assertAll();
    }

    @Test
    public void factorialOfZeroTest() {
        assertEquals(factorialCalculator.calculateFactorial(0),BigInteger.ONE);
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
        assertEquals(factorialCalculator.calculateFactorial(100),
                new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000")
        );
    }
}