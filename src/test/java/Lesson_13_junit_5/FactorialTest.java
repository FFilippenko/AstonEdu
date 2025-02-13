package Lesson_13_junit_5;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    //ПОЗИТИВНЫЕ ТЕСТЫ

    //Тест № 1. 0! = 1 (нижняя граница)
    @Test
    void testFactorialMinValue() {
        assertEquals(BigInteger.valueOf(1), Factorial.calculateFactorial(0), "0! = 1");
    }

    //Тест № 2. 1! = 1 (граничное значение)
    @Test
    void testFactorialOne() {
        assertEquals(BigInteger.valueOf(1), Factorial.calculateFactorial(1), "1! = 1");
    }

    // Тест 3. Факториал от 2! (первый случай работы цикла for)
    @Test
    void testFactorialTwo() {
        assertEquals(BigInteger.valueOf(2), Factorial.calculateFactorial(2), "2! = 2");
    }

    //Тест 4. Факториал от 3! (второй случай работы цикла)
    @Test
    void testFactorialThree() {
        assertEquals(BigInteger.valueOf(6), Factorial.calculateFactorial(3), "3! = 6");
    }

    //Тест №5. 24! (граничное значение)
    @Test
    void testFactorialTwentyFour() {
        assertEquals(new BigInteger("620448401733239439360000"), Factorial.calculateFactorial(24),
                "24! = 620448401733239439360000");
    }

    // Тест № 6. 25! =  (верхняя граница)
    @Test
    void testFactorialMaxValue() {
        assertEquals(new BigInteger("15511210043330985984000000"), Factorial.calculateFactorial(25),
                "25! = 15511210043330985984000000");
    }

    //НЕГАТИВНЫЕ ТЕСТЫ

    // Тест № 7. Факториал от -1! (граничное значение)
    @Test
    void testFactorialMinusOne() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(-1);
        });
        assertEquals("Факториал может быть только натуральным числом и в данной задаче вычисляются значения " +
                "для факториала от 0 до 25!", e.getMessage());
    }

    // Тест 8. Факториал от 26! (граничное значение)
    @Test
    void testFactorialTwentySix() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(26);
        });
        assertEquals("Факториал может быть только натуральным числом и в данной задаче вычисляются значения " +
                "для факториала от 0 до 25!", e.getMessage());
    }

    //Тест 9. Факториал от Integer.MAX_VALUE (нетипичный аргумент)
    @Test
    void factorialIntMaxValue() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculateFactorial(Integer.MAX_VALUE);
        });
        assertEquals("Факториал может быть только натуральным числом и в данной задаче вычисляются значения " +
                "для факториала от 0 до 25!", e.getMessage());
    }
}