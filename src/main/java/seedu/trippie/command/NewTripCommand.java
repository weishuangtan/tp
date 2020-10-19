package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

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
        System.out.print("Enter your new trip's name:");
        String name = ui.getLine();

        System.out.print("Enter the foreign exchange rate:");
        String forEx = ui.getLine();

        System.out.print("Enter your new trip's start date (dd-mm-yyyy):");
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = null;
        try {
            startDate = df.parse(ui.getLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Enter your budget for the trip:");
        Float budget = Float.parseFloat(ui.getLine());

        int index = trippieData.getTripList().size();

        Trip newTrip = new Trip(index, name, startDate);
        trippieData.getTripList().add(newTrip);
        trippieData.getCurrentTrip().getExpenseListObject().setBudgetValue(budget);

        System.out.println("Added the trip " + newTrip.toString());
        trippieData.setCurrentTripIndex(index);
        trippieData.loadCurrentTripFromFile();
    }
}
