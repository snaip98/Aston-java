package task1;

public class Animal {
    public String name;
    public int runningLimit;
    public int swimmingLimit;
    public static int count = 0;

    public void swim(int obstacleLength) {
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
        System.out.println("Количество животных: " + count);
    }
}
