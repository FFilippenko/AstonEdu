package lesson_3;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
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
    static void arrayDigitChange(){
        int[] digits = {1,1,0,0,1,0,1,1,0,0};
        for (int i=0; i < digits.length; i++){
            if (digits[i] == 0){
                digits[i] = 1;
            } else {
                digits[i] = 0;
            }
        }
        System.out.println(Arrays.toString(digits));
    }

    // Задание 11
    static void fillingArray(){
        int[] numbers = new int[100];
        for (int i=0; i < numbers.length; i++){
            numbers[i] = i+1;
        }
        System.out.println(Arrays.toString(numbers));
    }

    //Задание 12
    static void changeValueLesserThanSix(){
        int[] numbers = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i=0; i < numbers.length; i++){
            if (numbers[i]<6){
                numbers[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    // Задание 13
    static void matrixDiagonalChanger(){
        int[][] numbers = new int[10][10];
        for (int r=0; r < numbers.length; r++) {
            for (int c = 0; c < numbers[r].length; c++) {
                if (numbers[r] == numbers[c]) {
                    numbers[r][c] = 1;
                }
            }
        }
        for (int rr = numbers.length-1; rr >= 0; rr--) {
            for (int cc = 0; cc < numbers.length; cc++) {
                if (rr + cc == numbers.length-1) {
                    numbers[rr][cc] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(numbers).replace("], ","],\n"));
    }

    // Задание 14
    static int[] arrCreator (int len, int initialValue){
        int[] arr = new int[len];
        for (int i=0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}

