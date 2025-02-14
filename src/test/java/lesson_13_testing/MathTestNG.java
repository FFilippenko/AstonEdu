package lesson_13_testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertThrows;
import java.math.BigInteger;
import static org.testng.Assert.assertEquals;


public class MathTestNG {
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, BigInteger.ONE},
                {1, BigInteger.ONE},
                {2, new BigInteger("2")},
                {3, new BigInteger("6")},
                {5, new BigInteger("120")},
                {10, new BigInteger("3628800")},
                {20, new BigInteger("2432902008176640000")}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorial(int n, BigInteger expected) {
        assertEquals(Math.calculateFactorial(n), expected);
    }

    @DataProvider(name = "invalidFactorialData")
    public Object[][] invalidFactorialData() {
        return new Object[][]{
                {Integer.MAX_VALUE},
                {-1},
                {26},
                {Integer.MAX_VALUE}
        };
    }

    @Test(dataProvider = "invalidFactorialData")
    public void testFactorialInvalid(int n) {
        assertThrows(IllegalArgumentException.class, () -> Math.calculateFactorial(n));
    }
}