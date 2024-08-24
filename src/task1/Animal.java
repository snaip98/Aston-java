package task1;

public abstract class Animal {
    public String name;
    protected int runningLimit;
    protected int swimmingLimit;
    protected static int animalCount = 0;
    private boolean canSwim;

    public Animal(String name, int runningLimit, int swimmingLimit, boolean canSwim) {
        this.name = name;
        this.runningLimit = runningLimit;
        this.swimmingLimit = swimmingLimit;
        this.canSwim = canSwim;
    }

    public void swim(int obstacleLength) {
        if (!canSwim) {
            System.out.println(name + " не умеет плавать!");
            return;
        }
        if (obstacleLength <= swimmingLimit && obstacleLength > 0) {
            System.out.println(name + " проплыл " + obstacleLength + " м.");
        } else {
            System.out.println("передайте методу 'swim' аргумент в промежутке между 0 и " + swimmingLimit);
        }
    }

    public void run(int obstacleLength) {
        if (obstacleLength <= runningLimit && obstacleLength > 0) {
            System.out.println(name + " пробежал " + obstacleLength + " м.");
        } else {
            System.out.println("передайте методу 'run' аргумент в промежутке между 0 и " + runningLimit);
        }
    }

    public static void printCount() {
        System.out.println("Количество животных: " + animalCount);
    }
}