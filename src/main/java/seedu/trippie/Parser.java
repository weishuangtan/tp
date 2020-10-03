package seedu.trippie;

import seedu.trippie.command.Command;

public class Parser {

    private static final String SECTION_BREAK = "_______________________________________________";

    /*
    public static void pa {
        Scanner in = new Scanner(System.in);
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


    public static Command parse(String command) {
        //try here rmb
        if (command.equals("bye")) {
            //return new ExitCommand();
        } else {
            //return new AddCommand(command);
        }
        return null;
    }
}
