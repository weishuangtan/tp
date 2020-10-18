package seedu.trippie.command;

import seedu.trippie.data.Expense;
import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import java.util.List;

public class DeleteExpenditureCommand extends Command {

    private static final String FORMAT_ERROR_MESSAGE = "Incorrect format for [delete /e] command! Please try the "
            + "following:\nFormat: delete /e EXPENSE_INDEX\nExample: delete /e 3";
    private static final String PARAMETER_ERROR_MESSAGE = "Please check that the index keyed in is a number.";
    private static final String NULL_ERROR_MESSAGE = "Item has not been created yet. Enter a valid index.";

    private final int expenseIndex;

    public DeleteExpenditureCommand(String userInput) throws TrippieInvalidArgumentException {
        try {
            String[] segments = userInput.split("/e ");
            expenseIndex = Integer.parseInt(segments[1]) - 1;
        } catch (NumberFormatException e) {
            throw new TrippieInvalidArgumentException(PARAMETER_ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Trip trip, TripList tripList) {
        List<Expense> expenses = trip.getExpenseListObject().getExpenseList();
        if (expenseIndex >= 0 && expenseIndex < expenses.size()) {
            System.out.println("Noted. I've removed this item from the expenditure list.");
            System.out.println(expenses.get(expenseIndex).toString());
            expenses.remove(expenseIndex);
            System.out.println("There are " + expenses.size() + " items in the list.");
        } else {
            System.out.println(NULL_ERROR_MESSAGE);
        }
        trip.getExpenseListObject().setExpenseList(expenses);
    }
}
