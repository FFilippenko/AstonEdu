package org.aston;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(checkLeapYear(4));
    }

    // Задание 1
    public static void printThreeWords() {
        System.out.println("Orange,\nBanana,\nApple");
    }

    // Задание 2
    public static void checkSumSign() {
        int a = 5;
        int b = -6;
        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задание 3
    public static void printColor() {
        int value = 1000;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Задание 4
    static void compareNumbers() {
        int a = 100;
        int b = -1;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    // Задание 5
    static boolean checkSum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    // Задание 6
    static void printNumberSign(int a) {
        if (a < 0) {
            System.out.println("Отрицательное число");
        } else {
            System.out.println("Положительное число");
        }
    }

    // Задание 7
    static boolean checkNumberSign(int a) {
        return a < 0;
    }

    // Задание 8
    static void printStringAsMuchAsRequested(String a, int b) {
        for (int i = 0; i<b; i++){
        System.out.println(a);
        }
    }

    // Задание 9
    static boolean checkLeapYear(int year) {
        if (year%400 == 0){
            return true;
        } else if (year%100 == 0){
            return false;
        } else return year%4 == 0;
    }

    // Задание 10

}
