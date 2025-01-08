package lesson_4;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Менеджер по работе с клиентами", "ivanov@aston.edu", "+79111111111", 1000, 21);
        employees[1] = new Employee("Петров Петр Петрович", "Менеджер по логистике", "petrov@aston.edu", "+79112222222", 2000, 22);
        employees[2] = new Employee("Александров Александр Александрович", "Менеджер по продажам", "alexandrov@aston.edu", "+79113333333", 3000, 23);
        employees[3] = new Employee("Николаев Николай Николаевич", "Бухгалтер", "nikolaev@aston.edu", "+79114444444", 4000, 24);
        employees[4] = new Employee("Филиппенко Филипп Филиппович", "Менеджер по ВЭД", "filippenko@aston.edu", "+79115555555", 5000, 25);
    }
}