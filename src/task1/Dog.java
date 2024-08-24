package task1;

public class Dog extends Animal {
    int runningLimit = 500;
    int swimmingLimit = 10;
    public static int dogCount = 0;

    public Dog(String name) {
        dogCount++;
        this.count = count;
        this.name = name;
        super.runningLimit = runningLimit;
        super.swimmingLimit = swimmingLimit;
    }

    @Override
    public void run(int obstacleLength) {
        super.run(obstacleLength);
    }

    public void swim(int obstacleLength) {
        super.swim(obstacleLength);
    }


    public static void printCount() {
        System.out.println("Количество собак: " + dogCount);
    }
}
