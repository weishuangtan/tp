package seedu.trippie.command;

import seedu.trippie.ExpenditureList;
import seedu.trippie.Product;
import seedu.trippie.Ui;

import java.util.ArrayList;

import static seedu.trippie.Product.extractItemName;

public class AddExpenditureCommand extends Command {
    Product itemEntry;

    public AddExpenditureCommand(ArrayList<Product> expenditureList, String command) {

        String itemName = extractItemName(command);
        String itemCost = Product.extractItemCost(command);
        String dayBought = Product.extractDayBought(command);
        itemEntry = new Product(itemName, itemCost, dayBought);
        Ui.printLine();
        System.out.println("Got it! I've added the following item: " + itemEntry.toString());
        expenditureList.add(itemEntry);
        ExpenditureList.numberOfItemsTracker(expenditureList);
        Ui.printLine();
    }
}
