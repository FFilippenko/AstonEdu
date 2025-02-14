package lesson_13_junit_5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

public class MathTest {
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "10, 3628800",
            "24, 620448401733239439360000",
            "25, 15511210043330985984000000"
    })
    void testFactorialSuccess(int n, String expectedFactorialValue) {
        assertEquals(new BigInteger(expectedFactorialValue), Math.calculateFactorial(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 26, Integer.MAX_VALUE})
    void testFactorialFail(int n) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Math.calculateFactorial(n);
        });
        assertEquals("Ожидается значение от 0 до 25", e.getMessage());
    }
}