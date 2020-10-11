package seedu.trippie;

import seedu.trippie.command.*;

import java.util.IllegalFormatException;

public class Parser {

    public static Command parse(String command) {
        try {
            if (command.equals("exit")) {
                return new ExitCommand();
            } else if (command.startsWith("buy ")) {
                return new AddExpenseCommand(command);
            } else if (command.startsWith("delete /e ")) {
                return new DeleteExpenditureCommand(command);
            } else if (command.equals("list /e")) {
                return new ListExpenditureCommand();
            } else if (command.equals("spending")) {
                return new DisplayTotalExpenditureCommand();
            } else if (command.startsWith("add ")) {
                return new AddPlaceCommand(command);
            } else if (command.startsWith("delete /p ")) {
                return new DeletePlaceCommand(command);
            } else if (command.startsWith("help")) {
                return new HelpCommand();
            } else {
                System.out.println("Invalid Command! Type \"help\" to view the list of available commands!");
            }
        } catch (IllegalFormatException e) {
            System.out.println("Invalid Command!");
        }
        return null;
    }
}
