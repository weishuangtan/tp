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
        //add /n Jurong East Mall /d 2 /t 11.00-14.00
        String withoutDay = userInput.split(" /d ")[0];
        String name = withoutDay.split(" /n ")[1];
        return name;
    }

    public String extractDay(String userInput) {
        String withoutTime = userInput.split(" /t ")[0];
        String day = withoutTime.split(" /d ")[1];
        return day;
    }

    public String extractTime(String userInput) {
        String time = userInput.split(" /t ")[1];
        return time;
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
