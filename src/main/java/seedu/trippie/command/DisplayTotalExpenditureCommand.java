package seedu.trippie.command;

import seedu.trippie.Expense;

import java.text.NumberFormat;
import java.util.List;

public class DisplayTotalExpenditureCommand extends Command {

    public DisplayTotalExpenditureCommand() throws NumberFormatException {

    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute() {
        List<Expense> expenses = expense.getExpenseList();
        try {
            double amount = 0.00;
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String finalTotalExpenditure;
            for (Expense spending : expenses) {
                amount += Double.parseDouble(Expense.extractCostFromList(spending));
            }
            finalTotalExpenditure = formatter.format(amount);
            ui.printLine();
            System.out.println("Your current total spending is " + finalTotalExpenditure + ".");
            ui.printLine();
        } catch (NumberFormatException e) {
            System.out.println("Error! Incorrect number format.");
        }
    }
}
