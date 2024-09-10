import org.assertj.core.api.SoftAssertions;
import org.example.FactorialCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
   private FactorialCalculator factorialCalculator;

    @BeforeEach
    public void createCalculatorInstance(){
         factorialCalculator = new FactorialCalculator();
    }
    @Test
    @DisplayName("Calculate factorial for numbers between 0 and 100")
    public void factorialOfPositiveValuesTest() {
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
    @DisplayName("Calculate factorial of zero")
    public void factorialOfZeroTest() {
        assertEquals(factorialCalculator.calculateFactorial(0),BigInteger.ONE);
    }
    @DisplayName("Calculate factorial for negativ values")
    @Test
    public void factorialOfNegativeValueTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCalculator.calculateFactorial(-1));
    }
    @DisplayName("Throw exception for values greater than 100")
    @Test
    public void factorialOfBiggerThanOneHundredValueTest() {
        assertThrows(IllegalArgumentException.class, () -> factorialCalculator.calculateFactorial(101));
    }
    @DisplayName("factorial calculation 100")
    @Test
    public void factorialOfMaxValueTest() {
        assertEquals(factorialCalculator.calculateFactorial(100),
                new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000")
        );
    }
}