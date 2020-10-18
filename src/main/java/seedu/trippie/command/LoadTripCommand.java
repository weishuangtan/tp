package seedu.trippie.command;

import seedu.trippie.Trippie;
import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadTripCommand extends Command {

    public LoadTripCommand() {
    }

    public boolean isExit() {
        return false;
    };

    public void execute(Ui ui, Trip trip, TripList tripList) {
        System.out.println("Here are your existing trips.");
        System.out.println(tripList.list());
        System.out.print("Which one do you want to load? Enter the index:");
        int index = Integer.parseInt(ui.getLine());

        Trippie.currentTripIndex = index;
    };
}
