package seedu.trippie.command;

import seedu.trippie.Expense;
import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

import java.util.List;

public class DeleteExpenditureCommand extends Command {

    private int expenseIndex;

    public DeleteExpenditureCommand(String userInput) {
        try {
            String[] segments = userInput.split("-e ");
            expenseIndex = Integer.parseInt(segments[1]) - 1;
        } catch (NullPointerException e) {
            System.out.println("It is empty.");
        } catch (NumberFormatException e) {
            System.out.println("It must be number.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expense) {
        List<Expense> expenses = expense.getExpenseList();
        if (expenseIndex >= 0 && expenseIndex < expenses.size()) {
            System.out.println("Noted. I've removed this item from the expenditure list.");
            System.out.println(expenses.get(expenseIndex).toString());
            expenses.remove(expenseIndex);
            System.out.println("There are " + expenses.size() + " items in the list.");
        } else {
            System.out.println("Item has not been created yet. Enter a valid index.");
        }
        expense.setExpenseList(expenses);
    }
}
