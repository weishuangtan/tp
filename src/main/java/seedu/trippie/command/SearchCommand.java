package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Place;
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

    public void execute(Ui ui, TrippieData trippieData) {
        List<Place> list = trippieData.getCurrentTrip().getPlaceListObject().getPlaceList();
        int size = list.size();
        String listPlurality = size > 1 ? "are" : "is";
        String placePlurality = size > 1 ? "places" : "place";
        if (size == 0) {
            System.out.println("There is currently nothing in your place list. Why not add one?");
        } else {
            System.out.printf("Here %s the matching %s in your list:%n", listPlurality, placePlurality);
            int startingNumber = 1;
            for (Place place : list) {
                if (place.toString().toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println(startingNumber + "." + place.toString() + " on DAY " + place.getPlaceDay());
                    startingNumber++;
                }
            }
            if (startingNumber == 1) {
                System.out.println("Sorry I can't find any place with the keyword \"" + keyword + "\"");
            }
        }
    }
}
