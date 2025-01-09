package lesson_5_figures;

public class Cat extends Animal {
    boolean hunger;
    int bellyful; // показатель сытости

    public Cat(String name, int age, int runLength, int swimLength, boolean hunger, int bellyful) {
        super(name,age,runLength,swimLength);
        this.hunger = hunger;
        this.bellyful = bellyful;
    }

    public boolean eat(){
        return true;
    }

    @Override
    public String run(int runLength){
        if (runLength <= 200 && runLength >= 0) {
            return "Котик " + name + " пробежал " + runLength + " м";
        } else {
            return "Котик " + name + " не может столько пробежать(";
        }
    }

    @Override
    public void swim(int swimLength){
        System.out.println("Котик " + name + " не умеет плавать(");
    }


    public void printResult(){
        System.out.println("КОТ");
        System.out.println("Имя кота: " + name);
        System.out.println("Возраст кота: " + age);
        if (hunger == true){
            System.out.println("Статус сытости: сыт");
        } else {
            System.out.println("Статус сытости: голоден");
        }

    }



}
