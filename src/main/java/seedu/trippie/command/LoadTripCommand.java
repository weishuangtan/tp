package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.TrippieData;

public class LoadTripCommand extends Command {

    public LoadTripCommand() {
    }

    public boolean isExit() {
        return false;
    }

    public void execute(Ui ui, TrippieData trippieData) {
        System.out.println("Here are your existing trips.");
        System.out.println(trippieData.list());
        int index = 0;
        do {
            try {
                System.out.print("Which one do you want to load? Enter the index:");
                index = Integer.parseInt(ui.getLine());
                trippieData.setCurrentTripFromIndex(index - 1);
                trippieData.loadCurrentTripFromFile();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid trip number!");
            } catch (IndexOutOfBoundsException e) {
                index = 0;
                System.out.println("Trip cannot be found! Please enter a valid trip number from the list.");
            }

        } while (index == 0);


    }
}
