package task1.Staff;

public class Bowl {
    private static double foodAmountInTheBowl = 0;
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