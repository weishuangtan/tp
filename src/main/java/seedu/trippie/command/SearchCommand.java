package seedu.trippie.command;

import seedu.trippie.data.Place;
import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

import java.util.List;

public class SearchCommand extends Command {

    private final String keyword;

    public SearchCommand(String command) {
        String parsedResponse;
        parsedResponse = command.split(" ", 2)[1];
        this.keyword = parsedResponse;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public void execute(Ui ui, Trip trip, TrippieData trippieData) {
        List<Place> list = trip.getPlaceListObject().getPlaceList();
        int size = list.size();
        String listPlurality = size > 1 ? "are" : "is";
        String placePlurality = size > 1 ? "places" : "place";
        if (size == 0) {
            System.out.println("Your itinerary is empty!");
        } else {
            System.out.printf("Here %s the matching %s in your list:%n", listPlurality, placePlurality);
            int startingNumber = 1;
            for (Place place1 : list) {
                if (place1.toString().contains(keyword)) {
                    System.out.println(startingNumber + "." + place1.toString() + " on DAY " + place1.getPlaceDay());
                    startingNumber++;
                }
            }
            if (startingNumber == 1) {
                System.out.println("Sorry I can't find any task with the keyword \"" + keyword + "\"");
            }
        }
    }
}
