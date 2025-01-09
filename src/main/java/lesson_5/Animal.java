package lesson_5;

abstract class Animal {
    String name;
    int age;
    int maxLengthRun;
    int maxLengthSwim;
    static int counter;

    public void run(int length){
        if (length <= maxLengthRun && length>0){
            System.out.println(name + " пробежал " + length + " м");
        } else {
            System.out.println(name + "ничего не пробежал");
        }

    }

    public void swim(int length){
        if (length <= maxLengthSwim && length>0){
            System.out.println(name + " проплыл " + length + " м");
        } else {
            System.out.println(name + "ничего не проплыл");
        }

    }

    public Animal(String name, int age, int maxLengthRun, int maxLengthSwim) {
        this.name = name;
        this.age = age;
        this.maxLengthRun = maxLengthRun;
        this.maxLengthSwim = maxLengthSwim;
        counter++;
    }
}
