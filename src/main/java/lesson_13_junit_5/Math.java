package lesson_13_junit_5;

import java.math.BigInteger;

public class Math {
    static public BigInteger calculateFactorial(int n) {
        if (n < 0 || n > 25) {
            throw new IllegalArgumentException("Ожидается значение от 0 до 25");
        }

        BigInteger result = BigInteger.valueOf(1);
        if (n == 0) {
            return result;
        }

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}