package seedu.trippie.command;

import seedu.trippie.Expense;

import java.util.List;


public class AddExpenseCommand extends Command {

    private Expense expenseEntry;
    private final String expenseName;
    private final String expenseCost;
    private final String expenseDayBought;

    public AddExpenseCommand(String userInput) {
        this.expenseName = extractExpenseName(userInput);
        this.expenseCost = extractExpenseCost(userInput);
        this.expenseDayBought = extractDayBought(userInput);
    }

    public String extractExpenseName(String userInput) {
        int startIndex = userInput.indexOf("-i") + 2;
        int endIndex = userInput.indexOf("-c") - 1;
        return userInput.substring(startIndex,endIndex).trim();
    }

    public String extractExpenseCost(String userInput) {
        int startIndex = userInput.indexOf("-c") + 2;
        int endIndex = userInput.indexOf("-d") - 1;
        String expenseCost = userInput.substring(startIndex,endIndex).trim();
        if (expenseCost.contains("$")) {
            expenseCost = expenseCost.replace("$", "");
        }
        return expenseCost;
    }

    public String extractDayBought(String userInput) {
        int startIndex = userInput.indexOf("-d") + 2;
        return userInput.substring(startIndex).replaceAll("[^0-9]","").trim();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute() {
        List<Expense> expenses = expense.getExpenseList();
        if (expenses == null) {
            System.out.println("I'm null.");
        } else {
            ui.printLine();
            expenseEntry = new Expense(expenseName, expenseCost, expenseDayBought);
            expenses.add(expenseEntry);
            System.out.println("Got it! I've added the following item: " + expenseEntry.toString());
            System.out.println("There are " + expenses.size() + " items in the list.");
            ui.printLine();
            expense.setExpenseList(expenses);
        }
    }
}
