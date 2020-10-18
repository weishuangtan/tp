package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;

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
    public void execute(Ui ui, Trip trip, TripList tripList) {
        if (budgetValue == null) {
            System.out.println("Budget was not set successfully.");
            return;
        }
        trip.getExpenseListObject().setBudgetValue(budgetValue);
        System.out.println("Successfully set your total budget to " + budgetValue.toString());
    }
}
