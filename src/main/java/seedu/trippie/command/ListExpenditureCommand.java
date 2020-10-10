package seedu.trippie.command;

import seedu.trippie.Product;
import seedu.trippie.Ui;

import java.util.ArrayList;

public class ListExpenditureCommand extends Command {

    public ListExpenditureCommand(ArrayList<Product> expenditureList) {
        if (expenditureList.isEmpty()) {
            Ui.printLine();
            System.out.println("There is currently nothing in your expenditure list.");
        } else {
            int listIndex = 1;
            Ui.printLine();
            System.out.println("Expenditure List:");
            Ui.printLine();
            for (Product product: expenditureList) {
                System.out.println("[" + listIndex + "] " + product.toString());
                listIndex++;
            }
        }
        Ui.printLine();
    }
}
