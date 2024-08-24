package task1;

public class Cat extends Animal {
    int runningLimit = 200;
    public static int catCount = 0;
    public boolean catsSatiety;
    public static double foodAmountInTheBowl = 0;

    public Cat(String name) {
        catCount++;
        this.name = name;
        super.runningLimit = runningLimit;

    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println(name + " не умеет плавать!");
    }

    public void eatFromBowl(double catAppetite) {
        if (foodAmountInTheBowl >= catAppetite) {
            foodAmountInTheBowl = foodAmountInTheBowl - catAppetite;
            catsSatiety = true;
        } else {
            System.out.println("Наполните миску!");
        }
    }

    public static void addFoodToBowl(double food) {
        foodAmountInTheBowl = foodAmountInTheBowl + food;
    }

    public double getFoodAmount() {
        return foodAmountInTheBowl;
    }

    public static void printCount() {
        System.out.println("Количество котов: " + catCount);
    }
}
