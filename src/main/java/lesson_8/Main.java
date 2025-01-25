package lesson_8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("Урок 8. Задание 1");
        String[] wordsArray = {
                "Анна", "Стол", "Книга", "Василий", "Окно",
                "Лампа", "Река", "Дмитрий", "Школа", "Вода",
                "Стол", "Школа", "Тетрадь", "Дерево", "Школа",
                "Карандаш", "Анна", "Телефон", "Василий", "Ручка"
        };
        Map<String, Integer> counterBook = new HashMap<>();

        for (int i = 0; i < wordsArray.length; i++) {
            counterBook.put(wordsArray[i], counterBook.getOrDefault(wordsArray[i], 0) + 1);
        }

        System.out.println("Список уникальных значений:");
        for (Map.Entry<String, Integer> entry : counterBook.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println();
        System.out.println("Количество повторений каждого значения:");
        for (Map.Entry<String, Integer> entry : counterBook.entrySet()) {
            System.out.println("Значение <" + entry.getKey() + "> повторяется -> " + entry.getValue() + " раз");
        }
        System.out.println();
    }

    public static void task2() {
        System.out.println("Урок 8. Задание 2");
        PhoneBook book = new PhoneBook();
        book.add("Иванов", "+79111111111");
        book.add("Петров", "+79222222222");
        book.add("Петров", "+79333333333");
        book.get("Иванов");
        book.get("Петров");
        book.get("Сидоров");
    }
}
