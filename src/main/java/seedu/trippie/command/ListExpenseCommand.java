package seedu.trippie.command;

import seedu.trippie.Expense;
import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;
import seedu.trippie.exception.TrippieExceedBudgetException;

import java.util.List;

public class ListExpenseCommand extends Command {

    private static final String EXCEED_BUDGET_MESSAGE = "WARNING! You have exceeded your initial budget.\n"
            + "Recommended action: Increase budget limit.";

    private static final int BAR_SIZE = 10;
    private static final String SYMBOL_START_BOUNDARY = "[";
    private static final String SYMBOL_SPEND = "=";
    private static final String SYMBOL_REMAINING = "-";
    private static final String SYMBOL_END_BOUNDARY = "]";

    public ListExpenseCommand() {
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expenseList) {
        List<Expense> expenses = expenseList.getExpenseList();
        float exchangeRate = 3.01F;
        if (expenses.isEmpty()) {
            System.out.println("There is currently nothing in your Expense list.");
        } else {
            int listIndex = 1;
            Float pricing = expenseList.getBudgetValue();
            if (pricing != null) {
                System.out.println("Total budget: $" + String.format("%.2f", pricing)
                        + " (" + String.format("%.2f", pricing/exchangeRate) + " SGD)");
            } else {
                System.out.println("Total budget has not been set");
            }
            System.out.println("Expense List:");
            for (Expense expense: expenses) {
                System.out.println("[" + listIndex + "] " + expense.getExpense());
                listIndex++;
            }
            System.out.println("Your current total spending is $"
                    + String.format("%.2f",expenseList.getTotalExpenses())
                    + " (" + String.format("%.2f", expenseList.getTotalExpenses()/exchangeRate) + " SGD)");
            try {
                if (pricing != null) {
                    float remainingBudget = pricing - expenseList.getTotalExpenses();
                    checkRemainingBudget(remainingBudget,exchangeRate);
                    createBudgetPercentageBar(expenseList.getTotalExpenses(), pricing);
                }
            } catch (TrippieExceedBudgetException e) {
                System.out.println(EXCEED_BUDGET_MESSAGE);
            }
        }
    }

    private void checkRemainingBudget(float remainingBudget, float exchangeRate) {
        if (remainingBudget < 0) {
            System.out.print("");
        } else {
            System.out.println("Your current remaining budget is $"
                    + String.format("%.2f", remainingBudget)
                    + " (" + String.format("%.2f", remainingBudget/exchangeRate) + " SGD)");
        }
    }

    public static void createBudgetPercentageBar (float spent, float budget) throws TrippieExceedBudgetException {
        if (spent == budget) {
            System.out.println("You have spent finish your budget.");
        } else if (spent > budget) {
            throw new TrippieExceedBudgetException(EXCEED_BUDGET_MESSAGE);
        } else {
            System.out.println("You are still spending within your budget.");
        }
        float spentPercentage = (100 * spent) / budget;
        float spentLength = BAR_SIZE * spentPercentage / 100;
        StringBuilder bar = new StringBuilder(SYMBOL_START_BOUNDARY);
        for (int i = 0; i < BAR_SIZE; i++) {
            if (i < spentLength) {
                bar.append(SYMBOL_SPEND);
            } else {
                bar.append(SYMBOL_REMAINING);
            }
        }
        bar.append(SYMBOL_END_BOUNDARY);
        System.out.println(bar + " "
                + String.format("%.1f", spentPercentage) + "%");
    }
}