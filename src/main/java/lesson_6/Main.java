package lesson_6;

public class Main {
    public static void main(String[] args) {
        String[][] validArray = {                       //Массив, соответствующий условиям
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] arrayWithNonIntSymbol = {            //Массив, содержащий букву
                {"1", "a", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] arrayWithLessLengthElem = {           //Массив, имеющий элемент с меньшей, чем задано, длиной
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] arrayWithNullValueOfElem = {          // Массив, содержащий значение элемента null
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", null},
                {"1", "2", "3", "4"},
        };

        String[][] arrayWithLessLength = {              // Массив, имеющий меньшую, чем задано, длину
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] arrayWithNullArray = {               // Массив, содержащий значение null
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                null,
        };

        String[][][] allArr = {                         // Массив, содержащий все примеры
                validArray,
                arrayWithNonIntSymbol,
                arrayWithLessLengthElem,
                arrayWithNullValueOfElem,
                arrayWithLessLength,
                arrayWithNullArray
        };

        for (int i = 0; i < allArr.length; i++) {
            printSum(allArr[i]);
        }
    }
    
    private static void printSum(String[][] arr) {
        try {
            ArrayProcess.calculateElementSum(arr);
            int sum = ArrayProcess.calculateElementSum(arr);
            System.out.println("Сумма всех чисел массива составляет: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
