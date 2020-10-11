package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.Place;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

import java.util.List;

public class DeletePlaceCommand extends Command{
    private int placeIndex;

    public DeletePlaceCommand(String userInput) {
        try {
            String[] segments = userInput.split("-e ");
            placeIndex = Integer.parseInt(segments[1]) - 1;
        } catch (NullPointerException e) {
            System.out.println("It is empty.");
        } catch (NumberFormatException e) {
            System.out.println("It must be number.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expense) {
        List<Place> places = place.getPlaceList();
        if (placeIndex >= 0 && placeIndex < places.size()) {
            System.out.println("Noted. I've removed this place.");
            System.out.println(places.get(placeIndex).toString());
            places.remove(placeIndex);
            System.out.println("There are " + places.size() + " items in the list.");
        } else {
            System.out.println("Enter a valid index.");
        }
        place.setPlaceList(places);
    }
}
