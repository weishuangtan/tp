package seedu.trippie.command;

import seedu.trippie.ExpenditureList;
import seedu.trippie.Product;
import seedu.trippie.Ui;

import java.text.NumberFormat;
import java.util.ArrayList;

public class DisplayTotalExpenditureCommand extends Command {

    public DisplayTotalExpenditureCommand(ArrayList<Product> expenditureList) throws NumberFormatException {
        try {
            double amount = 0.00;
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String finalTotalExpenditure;
            for (Product spending : expenditureList) {
                amount += Double.parseDouble(Product.extractCostFromList(spending));
            }
            finalTotalExpenditure = formatter.format(amount);
            Ui.printLine();
            System.out.println("Your current total spending is " + finalTotalExpenditure + ".");
            Ui.printLine();
        } catch (NumberFormatException e) {
            System.out.println("Error! Incorrect number format.");
        }
    }
}
