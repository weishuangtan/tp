package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

public class BudgetCommand extends Command {
    private Float budgetValue;
    private final String userInput;

    public BudgetCommand(String userInput) {
        this.budgetValue = null;
        this.userInput = userInput;
    }

    private Float extractBudgetValue(String userInput) throws NullPointerException, NumberFormatException {
        String budgetValueString = userInput.substring(7);
        return Float.parseFloat(budgetValueString);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expense) {
        try {
            this.budgetValue = extractBudgetValue(userInput);
            expense.setBudgetValue(budgetValue);
            System.out.println("Successfully set your total budget to " + String.format("%.2f", budgetValue));
        } catch (NullPointerException | NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Incorrect format for [budget] command! Please try the following: ");
            System.out.println("Format: budget BUDGET");
            System.out.println("Example: budget 4000");
        }
    }
}
