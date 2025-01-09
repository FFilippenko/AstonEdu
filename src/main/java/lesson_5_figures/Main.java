package lesson_5_figures;

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
        cat[0] = new Cat("Барсик", 10, 40,  0, true, 0);
        cat[1] = new Cat("Персик", 5, 50, 0, true,  0);
        cat[2] = new Cat("Пальмира", 6, 80,0,true,  0);
        cat[3] = new Cat("Котофей", 8, 200, 0, true,  0);
        cat[4] = new Cat("Кузьма", 1, 150, 0, true,  0);

        Dog dog = new Dog("Бобик", 3, 500, 5);

        for (int i = 0; i < cat.length; i++) {
            cat[i].swim(cat[i].swimLength);
        }

        dog.swim(dog.swimLength);
    }
}