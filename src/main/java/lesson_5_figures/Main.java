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
    }
}