package seedu.trippie;

import seedu.trippie.command.AddExpenseCommand;
import seedu.trippie.command.Command;
import seedu.trippie.command.DeleteExpenditureCommand;
import seedu.trippie.command.DisplayTotalExpenditureCommand;
import seedu.trippie.command.ListExpenditureCommand;

import java.util.IllegalFormatException;

public class Parser {

    public static Command parse(String command) {
        try {
            if (command.equals("bye")) {
                //return new ExitCommand();
            } else if (command.startsWith("buy ")) {
                return new AddExpenseCommand(command);
            } else if (command.startsWith("delete -e ")) {
                return new DeleteExpenditureCommand(command);
            } else if (command.equals("list -e")) {
                return new ListExpenditureCommand();
            } else if (command.equals("spending")) {
                return new DisplayTotalExpenditureCommand();
            }
        } catch (IllegalFormatException e) {
            System.out.println("Invalid Command");
        }
        return null;
    }
}
