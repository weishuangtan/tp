package seedu.trippie.command;

import seedu.trippie.data.ExpenseList;
import seedu.trippie.data.PlaceList;
import seedu.trippie.Ui;

public abstract class Command {
    public abstract boolean isExit();

    public abstract void execute(Ui ui, PlaceList place, ExpenseList expense);
}
