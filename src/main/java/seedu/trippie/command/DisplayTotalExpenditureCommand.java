package seedu.trippie.command;

import seedu.trippie.Expense;
import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

import java.text.NumberFormat;
import java.util.List;

public class DisplayTotalExpenditureCommand extends Command {

    public DisplayTotalExpenditureCommand() throws NumberFormatException {

    }

    public static String extractCostFromList(Expense spending) {
        int startIndex = spending.getExpense().indexOf("- $") + 3;
        return spending.getExpense().substring(startIndex);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expenseList) {
        List<Expense> expenses = expenseList.getExpenseList();
        try {
            double amount = 0.00;
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String finalTotalExpenditure;
            for (Expense spending : expenses) {
                amount += Double.parseDouble(extractCostFromList(spending));
            }
            finalTotalExpenditure = formatter.format(amount);
            ui.printLine();
            System.out.println("Your current total spending is " + finalTotalExpenditure + ".");
            ui.printLine();
        } catch (NumberFormatException e) {
            System.out.println("Number Format incorrect");
        }
    }
}
