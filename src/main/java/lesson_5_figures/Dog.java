package lesson_5_figures;

public class Dog extends Animal {

    public Dog(String name, int age, int runLength, int swimLength) {
        super(name, age, runLength, swimLength);
    }

    @Override
    public String run(int runLength){
        if (runLength <= 500 && runLength >= 0) {
            return "Пёс " + name + " пробежал " + runLength + " м";
        } else {
            return "Пёсели столько не бегают(";
        }
    }

    @Override
    public void swim(int swimLength){
        if (swimLength <= 10 && swimLength >= 0) {
            System.out.println("Пёс " + name + " проплыл " + swimLength + " м");
        } else {
            System.out.println("Пёсели столько не плавают(");
        }

    }
}
