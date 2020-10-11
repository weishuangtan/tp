package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

public class ExitCommand extends Command {
    public ExitCommand() {

    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expense) {
        ui.showFarewells();
    }
}
