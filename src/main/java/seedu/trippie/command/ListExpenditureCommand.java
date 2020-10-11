package seedu.trippie.command;

import seedu.trippie.Expense;
import seedu.trippie.ExpenseList;
import seedu.trippie.Ui;

import java.util.List;

public class ListExpenditureCommand extends Command {
    public ListExpenditureCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(ExpenseList expenseList, Ui ui) {
        List<Expense> expenses = expenseList.getExpenseList();
        if (expenses.isEmpty()) {
            ui.printLine();
            System.out.println("There is currently nothing in your expenditure list.");
        } else {
            int listIndex = 1;
            ui.printLine();
            System.out.println("Expenditure List:");
            ui.printLine();
            for (Expense product: expenses) {
                System.out.println("[" + listIndex + "] " + product.toString());
                listIndex++;
            }
        }
        ui.printLine();
    }
}
