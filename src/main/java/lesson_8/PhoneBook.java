package lesson_8;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String contactName, String number) {
        List<String> contactNumbers = phoneBook.get(contactName);
        if (contactNumbers == null) {
            List<String> numbers = new ArrayList<>();
            numbers.add(number);
            phoneBook.put(contactName, numbers);
            return;
        }
        contactNumbers.add(number);
    }

    public List<String> get(String name) {
        List<String> contactNumbers = phoneBook.get(name);
        if (contactNumbers != null) {
            System.out.println("Контакт <" + name + "> имеет следующие контактные номера: " + contactNumbers);
            return contactNumbers;
        }
        System.out.println("Контакт <" + name + "> не найден в книге");
        return Collections.emptyList();
    }
}
