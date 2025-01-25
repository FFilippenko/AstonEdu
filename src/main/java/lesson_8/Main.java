package lesson_8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
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
            System.out.println("Значение <"+entry.getKey() + "> повторяется -> " + entry.getValue()+" раз");
        }
    }
}
