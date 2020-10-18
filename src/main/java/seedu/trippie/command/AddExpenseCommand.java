package seedu.trippie.command;

import seedu.trippie.data.Expense;
import seedu.trippie.Ui;
import seedu.trippie.data.ExpenseList;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;

import java.util.List;


public class AddExpenseCommand extends Command {

    private final String expenseName;
    private final String expenseCost;
    private final String expenseDayBought;

    public AddExpenseCommand(String userInput) {
        this.expenseName = extractExpenseName(userInput);
        this.expenseCost = extractExpenseCost(userInput);
        this.expenseDayBought = extractDayBought(userInput);
    }

    public String extractExpenseName(String userInput) {
        String withoutCost = userInput.split(" /c ")[0];
        return withoutCost.split(" /i ")[1];
    }

    public String extractExpenseCost(String userInput) {
        String withoutDay = userInput.split(" /d ")[0];
        String expenseCost = withoutDay.split(" /c ")[1];
        if (expenseCost.contains("$")) {
            expenseCost = expenseCost.replace("$", "");
        }
        return expenseCost;
    }

    public String extractDayBought(String userInput) {
        String onlyDay = userInput.split(" /d ")[1];
        return onlyDay.replaceAll("[^0-9]","").trim();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Trip trip, TripList tripList) {
        List<Expense> expenses = trip.getExpenseListObject().getExpenseList();
        ui.printLine();
        Expense expenseEntry = new Expense(expenseName, expenseCost, expenseDayBought);
        expenses.add(expenseEntry);
        System.out.println("Got it! I've added the following item: " + expenseEntry.toString());
        System.out.println("There are " + expenses.size() + " items in the list.");
        ui.printLine();
        trip.getExpenseListObject().setExpenseList(expenses);
    }
}
