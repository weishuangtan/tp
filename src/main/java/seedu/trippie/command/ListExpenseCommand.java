package seedu.trippie.command;

import seedu.trippie.data.Expense;
import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;

import java.util.List;

public class ListExpenseCommand extends Command {
    public ListExpenseCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Trip trip, TripList tripList) {
        List<Expense> expenses = trip.getExpenseListObject().getExpenseList();
        if (expenses.isEmpty()) {
            System.out.println("There is currently nothing in your Expense list.");
        } else {
            int listIndex = 1;
            Float pricing = trip.getExpenseListObject().getBudgetValue();
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
                    + String.format("%.2f",trip.getExpenseListObject().getTotalExpenses()));
        }
    }
}
