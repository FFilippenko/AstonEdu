package lesson_5;

public class Bowl {
    int food;


    public Bowl() {
        this.food = 18;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public boolean giveFood(int food) {
        if (food > this.food) {
            return false;
        }
        this.food -= food;
        return true;
    }
}

