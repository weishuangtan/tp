package seedu.trippie;

public class Expense {
    private final String expenseName;
    private final String expenseCost;
    private final String expenseDayBought;

    public Expense(String expenseName, String expenseCost, String expenseDayBought) {
        this.expenseName = expenseName;
        this.expenseCost = expenseCost;
        this.expenseDayBought = expenseDayBought;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public String getExpenseCost() {
        return expenseCost;
    }

    public String getExpenseDayBought() {
        return expenseDayBought;
    }

    public String getExpense() {
        return "Day " + getExpenseDayBought() + ": " + getExpenseName() + " - $" + getExpenseCost();
    }
}
