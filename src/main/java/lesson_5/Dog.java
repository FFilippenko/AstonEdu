package lesson_5;

public class Dog extends Animal {
    static int counter;

    public Dog(String name, int age) {
        super(name, age, 500, 10);
        counter++;
    }

    public void printResult() {
        System.out.println();
        System.out.println("ПЁС");
        System.out.println("Имя пса: " + name);
        System.out.println("Возраст пса: " + age);
        run(10);
        swim(8);
    }
}
