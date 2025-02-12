package Lesson_13_junit_5;

public class Main {
    public static void main(String[] args) {
try {
    System.out.println(Factorial.calculateFactorial(-5));
} catch (IllegalArgumentException e) {
    System.out.println("ОШИБКА: " + e.getMessage());
}
    }
}

