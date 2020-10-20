package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Expense;
import seedu.trippie.data.TrippieData;

import java.util.List;

public class ListExpenseCommand extends Command {
    public ListExpenseCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, TrippieData trippieData) {
        List<Expense> expenses = trippieData.getCurrentTrip().getExpenseListObject().getExpenseList();
        if (expenses.isEmpty()) {
            System.out.println("There is currently nothing in your expense list. Why not add one?");
        } else {
            int listIndex = 1;
            Float pricing = trippieData.getCurrentTrip().getExpenseListObject().getBudgetValue();
            if (pricing != null) {
                System.out.println("Total budget: $" + String.format("%.2f", pricing));
            } else {
                System.out.println("Total budget has not been set");
            }
            System.out.println("Expense List:");
            for (Expense expense: expenses) {
                System.out.println("[" + listIndex + "] " + expense.toString());
                listIndex++;
            }
            System.out.println("Your current total spending is $"
                    + String.format("%.2f",trippieData.getCurrentTrip().getExpenseListObject().getTotalExpenses()));
        }
    }
}
