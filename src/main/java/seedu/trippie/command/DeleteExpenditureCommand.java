package seedu.trippie.command;

import seedu.trippie.*;

import java.util.List;

public class DeleteExpenditureCommand extends Command {

    private final String userInput;

    public DeleteExpenditureCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expenseList) {
        List<Expense> expenses = expenseList.getExpenseList();
        try {
            String[] segments = userInput.split(" /e ");
            int expenseIndex = Integer.parseInt(segments[1]) - 1;
            if (expenseIndex >= 0 && expenseIndex < expenses.size()) {
                System.out.println("Noted. I've removed this item from the expenditure list.");
                System.out.println(expenses.get(expenseIndex).getExpense());
                expenses.remove(expenseIndex);
                System.out.println("There are " + expenses.size() + " items in the list.");
            } else {
                throw new TrippieException();
            }
        } catch (NumberFormatException e) {
            System.out.println("The index keyed in must be a number.");
        } catch (TrippieException e) {
            System.out.println("Item has not been created yet. Enter a valid index.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Incorrect format for [delete /e] command! Please try the following:");
            System.out.println("Format: delete /e EXPENSE_INDEX");
            System.out.println("Example: delete /e 3");
        }
        expenseList.setExpenseList(expenses);
    }
}
