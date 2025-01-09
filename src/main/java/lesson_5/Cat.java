package lesson_5;

public class Cat extends Animal {
    boolean isHunger;
    int bellyful; // показатель сытости
    static int counter;

    public Cat(String name, int age) {
        super(name, age, 200, 0);
        this.isHunger = true;
        this.bellyful = 0;
        counter++;
    }

    public boolean eat(Bowl bowl) {
        int hunger = 5;
        if (bowl.giveFood(hunger)) {
            isHunger = false;
            return true;
        }
        return false;
    }

    @Override
    public void swim(int length) {
        System.out.println("Котик " + name + " не умеет плавать(");
    }

    public void printResult() {
        System.out.println("КОТ");
        System.out.println("Имя кота: " + name);
        System.out.println("Возраст кота: " + age);
        if (isHunger) {
            System.out.println("Статус сытости: голоден");
        } else {
            System.out.println("Статус сытости: сыт");
        }
        run(50);
        swim(50);
    }
}
