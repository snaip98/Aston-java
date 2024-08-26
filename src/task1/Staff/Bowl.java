package task1.Staff;

public class Bowl {
    private double foodAmountInTheBowl;

    public void addFoodToBowl(double foodAmount) {
        foodAmountInTheBowl += foodAmount;
    }

    public void eatFromBowl(double foodAmount) {
        foodAmountInTheBowl -= foodAmount;

    }

    public double getFoodAmountInTheBowl() {
        return foodAmountInTheBowl;
    }
}