package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.Ui;

public abstract class Command {
    //protected Ui ui;
    //protected Storage storage;
    //protected ExpenseList expense;

    public abstract boolean isExit();

    public abstract void execute(ExpenseList expenses, Ui ui);
}
