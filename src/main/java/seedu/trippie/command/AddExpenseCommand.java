package seedu.trippie.command;

import seedu.trippie.Expense;
import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import java.util.Collections;
import java.util.List;


public class AddExpenseCommand extends Command {

    private static final String FORMAT_ERROR_MESSAGE = "Incorrect format for [buy] command! Please try the following:\n"
            + "Format: buy /i ITEM_NAME /c FINAL_COST /d DAY_NUMBER\n"
            + "Example: buy /i R&B Brown Sugar /c 3.00 /d 2";
    private static final String PARAMETER_ERROR_MESSAGE = "Please check that your FINAL_COST and DAY_NUMBER parameters"
            + "are in \nnumerical form.";

    private final String expenseName;
    private final Float expenseCost;
    private final int expenseDayBought;

    public AddExpenseCommand(String userInput) throws TrippieInvalidArgumentException {
        try {
            this.expenseName = extractExpenseName(userInput);
            this.expenseCost = extractExpenseCost(userInput);
            this.expenseDayBought = extractDayBought(userInput);
            char[] characters = userInput.toCharArray();
            if (characters[3] != ' ') {
                throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            throw new TrippieInvalidArgumentException(PARAMETER_ERROR_MESSAGE);
        }
    }

    public String extractExpenseName(String userInput) {
        String withoutCost = userInput.split(" /c ")[0];
        return withoutCost.split(" /i ")[1];
    }

    public Float extractExpenseCost(String userInput) {
        String withoutDay = userInput.split(" /d ")[0];
        String expenseCost = withoutDay.split(" /c ")[1];
        if (expenseCost.contains("$")) {
            expenseCost = expenseCost.replace("$", "");
        }
        return Float.parseFloat(expenseCost);

    }

    public int extractDayBought(String userInput) {
        String onlyDay = userInput.split(" /d ")[1];
        return Integer.parseInt(onlyDay);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expenseList) {
        List<Expense> expenses = expenseList.getExpenseList();
        Expense expenseEntry = new Expense(expenseName, expenseCost, expenseDayBought);
        expenses.add(expenseEntry);
        if (expenses.size() > 1) {
            sortExpenseList(expenses);
        }
        System.out.println("Got it! I've added the following item: " + expenseEntry.getExpense());
        System.out.println("There are " + expenses.size() + " items in the list.");
        expenseList.setExpenseList(expenses);
    }

    public void sortExpenseList(List<Expense> expenseList) {
        for (int i = 1; i < expenseList.size(); i++) {
            if (expenseList.get(i).getExpenseDayBought() < expenseList.get(i - 1).getExpenseDayBought()) {
                Collections.swap(expenseList, i, i - 1);
            }
        }
    }
}
