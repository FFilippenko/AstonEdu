package lesson_6;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("Ошибка: элемент массива с индексом [" + i + "][" + j + "] не является числом!");
    }
}
