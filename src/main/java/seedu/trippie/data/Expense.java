package seedu.trippie.data;

/**
 * Represents the individual expenses made by the user.
 * Stores the name of the item, its cost and the day it is bought.
 */
public class Expense {
    private final String expenseName;
    private final Float expenseCost;
    private final int expenseDayBought;

    public Expense(String expenseName, Float expenseCost, int expenseDayBought) {
        this.expenseName = expenseName;
        this.expenseCost = expenseCost;
        this.expenseDayBought = expenseDayBought;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public Float getExpenseCost() {
        return expenseCost;
    }

    public int getExpenseDayBought() {
        return expenseDayBought;
    }

    @Override
    public String toString() {
        return "Day " + getExpenseDayBought() + ": " + getExpenseName() + " - "
                + String.format("%.2f",getExpenseCost());
    }

}
