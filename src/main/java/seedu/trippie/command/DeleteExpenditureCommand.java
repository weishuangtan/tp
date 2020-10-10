package seedu.trippie.command;

import seedu.trippie.Product;
import seedu.trippie.Ui;

import java.util.ArrayList;

import static seedu.trippie.ExpenditureList.numberOfItemsTracker;

public class DeleteExpenditureCommand extends Command {

    public DeleteExpenditureCommand(ArrayList<Product> expenditureList, String userInput) {
        String[] segments = userInput.split("-e ");
        int expenseIndex = Integer.parseInt(segments[1]) - 1;
        if (expenseIndex < expenditureList.size()) {
            Ui.printLine();
            System.out.println("Noted. I've removed this item from the expenditure list.");
            System.out.println(expenditureList.get(expenseIndex).toString());
            expenditureList.remove(expenseIndex);
            numberOfItemsTracker(expenditureList);
        } else {
            Ui.printLine();
            System.out.println("Item has not been created yet. Enter a valid index.");

        }
    }
}
