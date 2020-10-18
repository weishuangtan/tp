package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TripList;

public abstract class Command {
    public abstract boolean isExit();

    public abstract void execute(Ui ui, Trip trip, TripList tripList);
}
