package lesson_5;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle("Красный", "Чаврек", 7, 5, 7);
        Circle circle = new Circle("Черный", "чОрный", 25);
        Rectangle rectangle = new Rectangle("Белый", "Беленький", 5, 10);


        Geometrical[] ps = new Geometrical[]{triangle, circle, rectangle};

        for (int i = 0; i < ps.length; i++) {
            ps[i].printParameters();
            System.out.println();
        }

        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Барсик", 5);
        cat[1] = new Cat("Персик", 3);
        cat[2] = new Cat("Пальмира", 6);
        cat[3] = new Cat("Котофей", 8);
        cat[4] = new Cat("Кузьма", 1);

        Dog dog = new Dog("Бобик", 3);

        Bowl bowl = new Bowl();
        for (int i = 0; i < cat.length; i++) {
            System.out.println();
            cat[i].eat(bowl);
            cat[i].printResult();
        }

        dog.printResult();
        System.out.println("-------------");
        System.out.println("Всего котов: " + Cat.counter);
        System.out.println("Всего псов: " + Dog.counter);
        System.out.println("Всего животных: " + Animal.counter);
        System.out.println("-------------");
    }
}