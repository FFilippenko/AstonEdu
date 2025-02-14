package lesson_13_testing;

import java.math.BigInteger;

public class Math {
    static public BigInteger calculateFactorial(int n) {
        if (n < 0 || n > 25) {
            throw new IllegalArgumentException("Ожидается значение от 0 до 25");
        }

        BigInteger result = BigInteger.valueOf(1);

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}