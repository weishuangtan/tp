package seedu.trippie;

import seedu.trippie.command.*;

import java.util.ArrayList;

public class Parser {

    /*
    public static void pa {

        ArrayList<Expenditure> expenditureList = new ArrayList<>();
        String userInput;
        Ui.greetUser();

        while (true) {
            userInput = in.nextLine();
            if (userInputExpenditureList(userInput)) {
                displayExpenditureList(expenditureList);
            } else if (userInputExpenditureBuy(userInput)) {
                buyItem(userInput, expenditureList);
            } else if (userInputExpenditureDelete(userInput)) {
                deleteItem(userInput, expenditureList);
            } else if (userInputExpenditureSpending(userInput)) {
                displayTotalExpenditure(expenditureList);
            } else if (userInputBye(userInput)) {
                System.out.println(SECTION_BREAK);
                System.out.println("See you again!");
                System.out.println(SECTION_BREAK);
                break;
            } else {
                System.out.println(SECTION_BREAK);
                System.out.println("Error! Unable to read command. Enter \"help\" for the list of commands.");
                System.out.println(SECTION_BREAK);
            }
        }
    }
     */


    public static Command parse(ArrayList<Product> expenditureList, String command) {
        //try here rmb
        if (command.equals("bye")) {
            //return new ExitCommand();
        } else if (command.equals("buy")) {
            return new AddExpenditureCommand(expenditureList, command);
        } else if (command.equals("delete -e")) {
            return new DeleteExpenditureCommand(expenditureList, command);
        } else if (command.equals("list -e")) {
            return new ListExpenditureCommand(expenditureList);
        } else if (command.equals("spending")) {
            return new DisplayTotalExpenditureCommand(expenditureList);
        }
            //return new AddCommand(command);
        return null;
    }
}
