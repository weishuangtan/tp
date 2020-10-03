package seedu.trippie;

import seedu.trippie.command.Expenditure;

import java.util.ArrayList;
import java.util.Scanner;

import static seedu.trippie.command.CommandList.userInputBye;
import static seedu.trippie.command.CommandList.userInputExpenditureBuy;
import static seedu.trippie.command.CommandList.userInputExpenditureDelete;
import static seedu.trippie.command.CommandList.userInputExpenditureList;
import static seedu.trippie.command.CommandList.userInputExpenditureSpending;
import static seedu.trippie.command.Expenditure.buyItem;
import static seedu.trippie.command.Expenditure.deleteItem;
import static seedu.trippie.command.Expenditure.displayExpenditureList;
import static seedu.trippie.command.Expenditure.displayTotalExpenditure;
import static seedu.trippie.command.GreetMessage.greetUser;

public class Trippie {
    private static final String SECTION_BREAK = "_______________________________________________";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Expenditure> expenditureList = new ArrayList<>();
        String userInput;
        greetUser();

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
}
