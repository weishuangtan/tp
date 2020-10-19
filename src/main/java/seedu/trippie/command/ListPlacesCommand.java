package seedu.trippie.command;

import seedu.trippie.data.Place;
import seedu.trippie.Ui;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

import java.util.Collections;
import java.util.List;

public class ListPlacesCommand extends Command {

    private final int specifiedDay;

    public ListPlacesCommand(String userInput) {
        specifiedDay = getSpecifiedDay(userInput);
    }

    public int getSpecifiedDay(String userInput) {
        String[] specificDay = userInput.split("/p");
        if (specificDay.length == 1) {
            return -1;
        } else {
            String[] finalDay = specificDay[1].split("/d");
            return Integer.parseInt(finalDay[1].trim());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, Trip trip, TrippieData trippieData) {
        List<Place> places = trip.getPlaceListObject().getPlaceList();
        sortPlaceList(places);

        if (places.size() == 0) {
            System.out.println("Please add your itinerary!");
        } else if (specifiedDay == -1) {
            int maxDay = places.get(places.size() - 1).getPlaceDay();
            for (int i = 1; i <= maxDay; i++) {
                System.out.println("DAY " + i + ":");
                for (int j = 0; j < places.size(); j++) {
                    if (places.get(j).getPlaceDay() == i) {
                        System.out.print((j + 1) + ". ");
                        System.out.println(places.get(j).toString());
                    }
                }
                System.out.println(System.lineSeparator());
            }
        } else {
            System.out.println("DAY " + specifiedDay + ": ");
            for (Place place : places) {
                if (place.getPlaceDay() == specifiedDay) {
                    System.out.println(place.toString());
                }
            }
        }
        trip.getPlaceListObject().setPlaceList(places);
    }

    public void sortPlaceList(List<Place> sortedPlaces) {

        for (int i = 0; i < sortedPlaces.size(); i++) {
            for (int j = i + 1; j < sortedPlaces.size(); j++) {
                if (sortedPlaces.get(i).getPlaceDay() == sortedPlaces.get(j).getPlaceDay()
                        && sortedPlaces.get(i).getPlaceStartTime() > sortedPlaces.get(j).getPlaceStartTime()) {
                    Collections.swap(sortedPlaces, i, j);
                } else if (sortedPlaces.get(i).getPlaceDay() > sortedPlaces.get(j).getPlaceDay()) {
                    Collections.swap(sortedPlaces, i, j);
                }
            }
        }

        /*
        sortedPlaces.stream().sorted(
                (place1, place2) -> {
                     place1.getPlaceStartTime().compareTo(place2.getPlaceStartTime());
                }
        ).sorted(
                (place1, place2) -> {
                    return place1.getPlaceDay().compareTo(place2.getPlaceDay());
                }
        );

         */
    }

}
