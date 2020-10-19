package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

public class ExitCommand extends Command {
    public ExitCommand() {

    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(Ui ui, Trip trip, TrippieData trippieData) {
        ui.showFarewells();
    }
}
