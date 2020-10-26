package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;
import seedu.trippie.exception.TrippieException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTripCommand extends Command {

    public NewTripCommand() {
    }

    public boolean isExit() {
        return false;
    }

    public void execute(Ui ui, TrippieData trippieData) {
        try {
            // Get trip name
            System.out.print("Enter your new trip's name:");
            final String name = ui.getLine();

            // Get start date
            Date startDate;
            do {
                System.out.print("Enter your new trip's start date (dd-mm-yyyy):");
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Date tempStartDate = null;
                try {
                    String input = ui.getLine();
                    if (!input.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
                        throw new ParseException("Invalid format", 0);
                    }
                    tempStartDate = df.parse(input);
                } catch (ParseException e) {
                    System.out.println("Give a valid date!");
                }
                startDate = tempStartDate;
            } while (null == startDate);


            // Get foreign exchange rate
            Float forEx = null;
            do {
                System.out.print("Enter the foreign exchange rate:");
                try {
                    forEx = Float.parseFloat(ui.getLine());
                } catch (NumberFormatException e) {
                    System.out.println("Give a valid exchange rate (in decimals)");
                }
            } while (forEx == null);


            // Get currency abbreviation
            String currencyAbbreviation = null;
            do {
                System.out.print("Enter the foreign currency abbreviation (eg. MYR): ");
                currencyAbbreviation = ui.getLine();
            } while (currencyAbbreviation == null);


            // Get budget
            Float budget = null;
            do {
                try {
                    System.out.print("Enter your budget for the trip (in SGD):");
                    budget = Float.parseFloat(ui.getLine());
                } catch (NumberFormatException e) {
                    System.out.println("Give a valid budget value (in decimals)");
                }
            } while (budget == null);

            // Get index
            int index = trippieData.getTripList().size();

            Trip newTrip = new Trip(index, name, startDate);
            newTrip.getExpenseListObject().setForExValue(forEx);
            newTrip.getExpenseListObject().setCurrencyAbbreviation(currencyAbbreviation);
            newTrip.getExpenseListObject().setBudgetValue(budget);
            trippieData.getTripList().add(newTrip);

            System.out.println("Added the trip " + newTrip.toString());
            trippieData.setCurrentTripFromIndex(index);
        } catch (TrippieException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to create new trip.");
        }
    }
}
