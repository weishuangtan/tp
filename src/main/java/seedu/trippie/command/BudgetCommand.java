package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

public class BudgetCommand extends Command {
    private final Float budgetValue;

    public BudgetCommand(String userInput) throws NullPointerException, NumberFormatException {
        this.budgetValue = extractBudgetValue(userInput);
    }

    private Float extractBudgetValue(String userInput) throws NullPointerException, NumberFormatException {
        String budgetValueString = userInput.replace("budget","").trim();
        return Float.parseFloat(budgetValueString);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expense) {
        expense.setBudgetValue(budgetValue);
        System.out.println("Successfully set your total budget to " + budgetValue.toString());
    }
}
