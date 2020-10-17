package seedu.trippie.command;

import seedu.trippie.*;

import java.util.List;


public class AddExpenseCommand extends Command {

    private final String userInput;

    public AddExpenseCommand(String userInput) {
            this.userInput = userInput;
    }

    public String extractExpenseName(String userInput) {
        String withoutCost = userInput.split(" /c ")[0];
        return withoutCost.split(" /i ")[1];
    }

    public Float extractExpenseCost(String userInput) {
        String withoutDay = userInput.split(" /d ")[0];
        String expenseCost = withoutDay.split(" /c ")[1];
        if (expenseCost.contains("$")) {
            expenseCost = expenseCost.replace("$", "");
        }
        return Float.parseFloat(expenseCost);

    }

    public int extractDayBought(String userInput) {
        String onlyDay = userInput.split(" /d ")[1];
        return Integer.parseInt(onlyDay);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expenseList) {
        try {
            List<Expense> expenses = expenseList.getExpenseList();
            Expense expenseEntry = new Expense(extractExpenseName(userInput), extractExpenseCost(userInput),
                    extractDayBought(userInput));
            expenses.add(expenseEntry);
            System.out.println("Got it! I've added the following item: " + expenseEntry.getExpense());
            System.out.println("There are " + expenses.size() + " items in the list.");
            expenseList.setExpenseList(expenses);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Incorrect format for [buy] command! Please try the following: ");
            System.out.println("Format: buy /i ITEM_NAME /c FINAL_COST /d DAY_NUMBER");
            System.out.println("Example: buy /i R&B Brown Sugar /c 3.00 /d 2");
        }
    }
}
