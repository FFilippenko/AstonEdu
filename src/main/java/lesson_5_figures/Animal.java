package lesson_5_figures;

public class Animal {
    String name;
    int age;
    int runLength;
    int swimLength;

    public String run(int runLength){
        return name + " пробежал " + runLength + " м";
    }

    public void swim(int swimLength){
        System.out.println(name + " проплыл " + swimLength + " м");
    }

    public Animal(String name, int age, int runLength, int swimLength) {
        this.name = name;
        this.age = age;
        this.runLength = runLength;
        this.swimLength = swimLength;
    }
}
