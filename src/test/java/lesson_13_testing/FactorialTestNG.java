package lesson_13_testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class FactorialTestNG {

    // ПОЗИТИВНЫЕ ТЕСТЫ

    // Тест № 1. 0! = 1 (нижняя граница)
    @Test
    void testFactorialMinValue() {
        Assert.assertEquals(Factorial.calculateFactorial(0), BigInteger.valueOf(1), "0! = 1");
    }


    //Тест № 2. 1! = 1 (граничное значение)
    @Test
    void testFactorialOne() {
        Assert.assertEquals(Factorial.calculateFactorial(1), BigInteger.valueOf(1), "1! = 1");
    }

    // Тест 3. Факториал от 2! (первый случай работы цикла for)
    @Test
    void testFactorialTwo() {
        Assert.assertEquals(Factorial.calculateFactorial(2), BigInteger.valueOf(2), "2! = 2");
    }

    //Тест 4. Факториал от 3! (второй случай работы цикла)
    @Test
    void testFactorialThree() {
        Assert.assertEquals(Factorial.calculateFactorial(3), BigInteger.valueOf(6), "3! = 6");
    }

    //Тест №5. 24! (граничное значение)
    @Test
    void testFactorialTwentyFour() {
        Assert.assertEquals(Factorial.calculateFactorial(24), new BigInteger("620448401733239439360000"),
                "24! = 620448401733239439360000");
    }

    // Тест № 6. 25! =  (верхняя граница)
    @Test
    void testFactorialMaxValue() {
        Assert.assertEquals(Factorial.calculateFactorial(25), new BigInteger("15511210043330985984000000"),
                "25! = 15511210043330985984000000");
    }

//НЕГАТИВНЫЕ ТЕСТЫ

    // Тест № 7. Факториал от -1! (граничное значение)
    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFactorialMinusOne() {
        Factorial.calculateFactorial(-1);
    }

    // Тест 8. Факториал от 26! (граничное значение)
    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFactorialTwentySix() {
        Factorial.calculateFactorial(26);
    }

    //Тест 9. Факториал от Integer.MAX_VALUE (нетипичный аргумент)
    @Test(expectedExceptions = IllegalArgumentException.class)
    void factorialIntMaxValue() {
        Factorial.calculateFactorial(Integer.MAX_VALUE);
    }
}