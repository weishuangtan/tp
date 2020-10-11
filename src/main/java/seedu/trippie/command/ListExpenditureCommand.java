package seedu.trippie.command;

import seedu.trippie.Expense;

import java.util.List;

public class ListExpenditureCommand extends Command {
    public ListExpenditureCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute() {
        List<Expense> expenses = expense.getExpenseList();
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
