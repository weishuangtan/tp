package seedu.trippie.command;

public class CommandList {
    public static boolean userInputExpenditureBuy (String userInput) {
        return userInput.toLowerCase().startsWith("buy");
    }

    public static boolean userInputExpenditureDelete (String userInput) {
        return userInput.toLowerCase().startsWith("delete -e");
    }

    public static boolean userInputExpenditureList (String userInput) {
        return userInput.toLowerCase().startsWith("list -e");
    }
}
