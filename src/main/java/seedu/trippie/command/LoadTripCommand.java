package seedu.trippie.command;

import seedu.trippie.Trippie;
import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

public class LoadTripCommand extends Command {

    public LoadTripCommand() {
    }

    public boolean isExit() {
        return false;
    }

    public void execute(Ui ui, Trip trip, TrippieData trippieData) {
        System.out.println("Here are your existing trips.");
        System.out.println(trippieData.list());
        System.out.print("Which one do you want to load? Enter the index:");
        int index = Integer.parseInt(ui.getLine());

        Trippie.currentTripIndex = index;
    }
}
