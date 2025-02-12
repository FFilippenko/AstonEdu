package Lesson_13_junit_5;

import java.math.BigInteger;

public class Factorial {
    static BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        if (n < 0) {
            throw new IllegalArgumentException("Факториал может быть только натуральным числом!");
        } else if (n == 0 || n == 1) {
            return result;
        }
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
