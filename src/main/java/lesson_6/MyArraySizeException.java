package lesson_6;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Ошибка: не соответствует размеру 4x4!");
    }
}
