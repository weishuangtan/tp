package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.Place;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

import java.util.List;

public class AddPlaceCommand extends Command{
    private final String name;
    private final String day;
    private final String time;

    public AddPlaceCommand(String userInput) {
        this.name = extractName(userInput);
        this.day = extractDay(userInput);
        this.time = extractTime(userInput);
    }

    public String extractName(String userInput) {
        int startIndex = userInput.indexOf("-n") + 2;
        int endIndex = userInput.indexOf("-d") - 1;
        return userInput.substring(startIndex,endIndex).trim();
    }

    public String extractDay(String userInput) {
        int startIndex = userInput.indexOf("-d") + 2;
        int endIndex = userInput.indexOf("-t") - 1;
        return userInput.substring(startIndex,endIndex).trim();
    }

    public String extractTime(String userInput) {
        int startIndex = userInput.indexOf("-t") + 2;
        return userInput.substring(startIndex).trim();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, PlaceList place, ExpenseList expense) {
        List<Place> places = place.getPlaceList();
        places.add(new Place(name, day, time));
        int size = places.size();
        System.out.println("Got it. I've added this place:");
        System.out.println(places.get(size - 1).getPlace());
        place.setPlaceList(places);
    }
}
