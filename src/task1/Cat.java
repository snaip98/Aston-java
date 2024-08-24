package task1;

public class Cat extends Animal {
    int runningLimit = 200;
    public static int catCount = 0;

    public Cat(String name) {
        catCount++;
        this.name = name;
        super.runningLimit = runningLimit;
    }

    @Override
    public void swim(int obstacleLength) {
        System.out.println(name + " не умеет плавать!");
    }

    public static void printCount() {
        System.out.println("Количество котов: " + catCount);
    }
}