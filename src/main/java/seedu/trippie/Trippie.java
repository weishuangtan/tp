package seedu.trippie;

import seedu.trippie.command.Expenditure;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

import static seedu.trippie.command.CommandList.*;
import static seedu.trippie.command.Expenditure.*;
import static seedu.trippie.command.GreetMessage.greetUser;

public class Trippie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Expenditure> expenditureList = new ArrayList<Expenditure>();
        String userInput;
        greetUser();

        while (true) {
            userInput = in.nextLine();
            if (userInputExpenditureList(userInput)) {
                displayExpenditureList(userInput, expenditureList);
            } else if (userInputExpenditureBuy(userInput)) {
                buyItem(userInput, expenditureList);
            } else if (userInputExpenditureDelete(userInput)) {
                deleteItem(userInput, expenditureList);
            } else {
                System.out.println("Error!");
            }
        }
    }
}
