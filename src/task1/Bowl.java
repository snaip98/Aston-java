package task1;

public class Bowl {
    public static double foodAmountInTheBowl = 0;
    public boolean catsSatiety;

    public void eatFromBowl(double catAppetite) {
        if (foodAmountInTheBowl >= catAppetite) {
            foodAmountInTheBowl -= catAppetite;
            catsSatiety = true;

        } else {
            System.out.println("Наполните миску!");
            catsSatiety = false;
        }
    }

    public void addFoodToBowl(double food) {
        foodAmountInTheBowl += food;
    }

    public double getFoodAmount() {
        return foodAmountInTheBowl;
    }
}