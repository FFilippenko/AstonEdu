package lesson_6;

public class ArrayProcess {
    public static int arrayCheck(String[][] arr) throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        if (arr.length == 4) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length == 4) {
                    for (int j = 0; j < arr[i].length; j++) {
                        try {
                            int z = Integer.parseInt(arr[i][j]);
                            sum += z;
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException("Ошибка: элемент массива с индексом [" + i + "][" + j + "] не является числом!")
                            ;
                        }
                    }
                } else {
                    throw new MyArraySizeException("Ошибка: не соответствует размеру 4x4!");
                }
            }
        } else {
            throw new MyArraySizeException("Ошибка: не соответствует размеру 4x4!");
        }
        return sum;

    }
}