package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.TrippieData;
import seedu.trippie.exception.TrippieInvalidArgumentException;

public class BudgetCommand extends Command {

    private static final String FORMAT_ERROR_MESSAGE = "Incorrect format for [budget] command! "
            + "Please try the following:\nFormat: budget BUDGET\nExample: budget 4000";
    private static final String PARAMETER_ERROR_MESSAGE = "Please check that the budget value is in numerical form.";
    private static final String NEGATIVE_BUDGET_MESSAGE = "Trippie doesn't know how to deal with negative budget";

    private Float budgetValue;

    public BudgetCommand(String userInput) throws TrippieInvalidArgumentException {
        this.budgetValue = null;
        try {
            char[] characters = userInput.toCharArray();
            if (characters[6] != ' ' | userInput.length() == 7) {
                throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
            } else {
                this.budgetValue = extractBudgetValue(userInput);
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            throw new TrippieInvalidArgumentException(PARAMETER_ERROR_MESSAGE);
        }
    }

    private Float extractBudgetValue(String userInput) throws TrippieInvalidArgumentException {
        String budgetValueString = userInput.substring(7);
        if (Float.parseFloat(budgetValueString) < 0) {
            throw new TrippieInvalidArgumentException(NEGATIVE_BUDGET_MESSAGE);
        }
        return Float.parseFloat(budgetValueString);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, TrippieData trippieData) {
        trippieData.getCurrentTrip().getExpenseListObject().setBudgetValue(budgetValue);
        System.out.println("Successfully set your total budget to " + String.format("%.2f", budgetValue));
    }
}
