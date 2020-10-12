package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

public class BudgetCommand extends Command {
    private Float budgetValue;

    public BudgetCommand(String userInput) {
        this.budgetValue = null;
        try {
            this.budgetValue = extractBudgetValue(userInput);
        } catch (NullPointerException e) {
            System.out.println("You need to state a valid value for your budget!");
        } catch (NumberFormatException e) {
            System.out.println("Budget needs to be input in decimals.");
        }
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
        if (budgetValue == null) {
            System.out.println("Budget was not set successfully.");
            return;
        }
        expense.setBudgetValue(budgetValue);
        System.out.println("Successfully set your total budget to " + budgetValue.toString());
    }
}
