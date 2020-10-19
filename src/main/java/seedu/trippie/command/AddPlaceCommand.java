package seedu.trippie.command;

import seedu.trippie.data.Place;
import seedu.trippie.Ui;
import seedu.trippie.data.TrippieData;

import java.util.List;

public class AddPlaceCommand extends Command {
    private final String name;
    private final int day;
    private final int start;
    private final int end;

    public AddPlaceCommand(String userInput) {
        this.name = extractName(userInput);
        this.day = extractDay(userInput);
        this.start = extractStartTime(userInput);
        this.end = extractEndTime(userInput);
    }

    public String extractName(String userInput) {
        //add /n Jurong East Mall /d 2 /t 1100 to 1400
        String withoutDay = userInput.split(" /d ")[0];
        return withoutDay.split(" /n ")[1];
    }

    public int extractDay(String userInput) {
        String withoutTime = userInput.split(" /t ")[0];
        String day = withoutTime.split(" /d ")[1];
        return Integer.parseInt(day.trim());
    }

    public int extractStartTime(String userInput) {
        String time = userInput.split(" /t ")[1];
        String start = time.split("to")[0];
        return Integer.parseInt(start.trim());
    }

    public int extractEndTime(String userInput) {
        String time = userInput.split(" /t ")[1];
        String end = time.split("to")[1];
        return Integer.parseInt(end.trim());
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, TrippieData trippieData) {
        List<Place> places = trippieData.getCurrentTrip().getPlaceListObject().getPlaceList();
        Place newPlace = new Place(name, day, start, end);
        places.add(newPlace);

        System.out.println("Got it. I've added this place:");
        System.out.println(newPlace);
        trippieData.getCurrentTrip().getPlaceListObject().setPlaceList(places);
    }
}
