package lesson_3;

public class Main {
    public static void main(String[] args) {

    }

    // Задание 1
    static void printThreeWords() {
        System.out.println("Orange,\nBanana,\nApple");
    }

    // Задание 2
    static void checkSumSign() {
        int a = 5;
        int b = -6;
        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задание 3
    static void printColor() {
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
    static void printString(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    // Задание 9
    static boolean checkLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }

    // Задание 10
    static void swapOneAndZero() {
        int[] digits = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                digits[i] = 1;
            } else {
                digits[i] = 0;
            }
        }
    }

    // Задание 11
    static void fillArray() {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
    }

    //Задание 12
    static void multiplyValuesLessThanSix() {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) {
                numbers[i] *= 2;
            }
        }
    }

    // Задание 13
    static void createArrayDiagonal() {
        int[][] numbers = new int[10][10];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (i == j || i + j == numbers.length - 1) {
                    numbers[i][j] = 1;
                }
            }
        }
    }

    // Задание 14
    static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}

