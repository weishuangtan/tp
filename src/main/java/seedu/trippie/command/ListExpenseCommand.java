package seedu.trippie.command;

import seedu.trippie.Expense;
import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

import java.util.List;

public class ListExpenseCommand extends Command {
    public ListExpenseCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expense) {
        List<Expense> expenses = expense.getExpenseList();
        if (expenses.isEmpty()) {
            ui.printLine();
            System.out.println("There is currently nothing in your Expense list.");
        } else {
            int listIndex = 1;
            ui.printLine();
            System.out.println("Total budget: " + String.format("%.2f", expense.getBudgetValue()));
            System.out.println("Expense List:");
            ui.printLine();
            for (Expense product: expenses) {
                System.out.println("[" + listIndex + "] " + product.toString());
                listIndex++;
            }
        }
        ui.printLine();
    }
}
