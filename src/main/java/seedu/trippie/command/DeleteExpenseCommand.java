package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Expense;
import seedu.trippie.data.TrippieData;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import java.util.List;

public class DeleteExpenseCommand extends Command {

    private static final String FORMAT_ERROR_MESSAGE = "You typed in the incorrect format for [delete /e] command! "
            + "Please try the following:\nFormat: delete /e EXPENSE_INDEX\nExample: delete /e 3";
    private static final String PARAMETER_ERROR_MESSAGE = "Please check that the index keyed in is a number.";
    private static final String NULL_ERROR_MESSAGE = "Sorry I can't find the expense. Please enter a valid index.";

    private final int expenseIndex;

    public DeleteExpenseCommand(String userInput) throws TrippieInvalidArgumentException {
        try {
            String index = userInput.split(" /e ")[1];
            expenseIndex = Integer.parseInt(index) - 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            throw new TrippieInvalidArgumentException(PARAMETER_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, TrippieData trippieData) {
        List<Expense> expenses = trippieData.getCurrentTrip().getExpenseListObject().getExpenseList();
        String currencyAbbreviation = trippieData.getCurrentTrip().getExpenseListObject().getCurrencyAbbreviation();
        if (expenseIndex >= 0 && expenseIndex < expenses.size()) {
            System.out.println("Noted. I've removed this item from the expenditure list.");
            System.out.println(expenses.get(expenseIndex).toString() + " " + currencyAbbreviation);
            expenses.remove(expenseIndex);
            System.out.printf("Now you have %d %s in the list.%n", expenses.size(), expenses.size() > 1 ? "items" :
                    "item");
        } else {
            System.out.println(NULL_ERROR_MESSAGE);
        }
        trippieData.getCurrentTrip().getExpenseListObject().setExpenseList(expenses);
    }
}
