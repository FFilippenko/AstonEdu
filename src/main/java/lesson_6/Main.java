package lesson_6;

public class Main {
    public static void main(String[] args) {
        String[][] myArr1 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        try {
            ArrayProcess.arrayCheck(myArr1);
            int sum = ArrayProcess.arrayCheck(myArr1);
            System.out.println("Сумма всех чисел массива составляет: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}