package seedu.trippie;


import seedu.trippie.command.AddExpenseCommand;
import seedu.trippie.command.AddPlaceCommand;
import seedu.trippie.command.BudgetCommand;
import seedu.trippie.command.Command;
import seedu.trippie.command.DeleteExpenditureCommand;
import seedu.trippie.command.DeletePlaceCommand;
import seedu.trippie.command.DisplayTotalExpenditureCommand;
import seedu.trippie.command.ExitCommand;
import seedu.trippie.command.HelpCommand;
import seedu.trippie.command.ListExpenseCommand;
import seedu.trippie.command.ListPlacesCommand;

import java.util.IllegalFormatException;

public class Parser {

    public static Command parse(String userInput) {
        try {
            if (userInput.equals("exit")) {
                return new ExitCommand();
            } else if (userInput.startsWith("buy ")) {
                return new AddExpenseCommand(userInput);
            } else if (userInput.startsWith("delete /e ")) {
                return new DeleteExpenditureCommand(userInput);
            } else if (userInput.equals("list /e")) {
                return new ListExpenseCommand();
            } else if (userInput.startsWith("budget")) {
                return new BudgetCommand(userInput);
            } else if (userInput.equals("spending")) {
                return new DisplayTotalExpenditureCommand();
            } else if (userInput.startsWith("add ")) {
                return new AddPlaceCommand(userInput);
            } else if (userInput.startsWith("delete /p ")) {
                return new DeletePlaceCommand(userInput);
            } else if (userInput.startsWith("help")) {
                return new HelpCommand();
            } else if (userInput.startsWith("list /p")) {
                return new ListPlacesCommand(userInput);
            } else {
                System.out.println("Invalid Command! Type \"help\" to view the list of available commands!");
            }
        } catch (IllegalFormatException e) {
            System.out.println("Invalid Command!");
        }
        return null;
    }
}
