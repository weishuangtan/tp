package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.Place;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

import java.util.ArrayList;
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
    public void execute(Ui ui, PlaceList placeList, ExpenseList expense) {
        List<Place> places = placeList.getPlaceList();
        placeSort(places);
        int maxDay = getMax(places);
        if (places.size() == 0) {
            System.out.println("Please add your itinerary!");
        }
        if (specifiedDay == -1) {
            for (int i = 1; i <= maxDay; i++) {
                System.out.println("DAY " + i + ": ");
                for (Place place : places) {
                    if (place.getPlaceDay() == i) {
                        System.out.println(place.getPlace());
                    }
                }
                System.out.println(System.lineSeparator());
            }
        } else {
            System.out.println("DAY " + specifiedDay + ": ");
            for (Place place : places) {
                if (place.getPlaceDay() == specifiedDay) {
                    System.out.println(place.getPlace());
                }
            }
        }
    }

    public int getMax(List<Place> places) {
        int maxDay = 1;
        for (Place place : places) {
            if (place.getPlaceDay() > maxDay) {
                maxDay = place.getPlaceDay();
            }
        }
        return maxDay;
    }

    public void placeSort(List<Place> sortedPlaces) {
        for (int i = 0; i < sortedPlaces.size(); i++) {
            for (int j = i + 1; j < sortedPlaces.size(); j++) {
                if (sortedPlaces.get(i).getPlaceDay() == sortedPlaces.get(j).getPlaceDay()
                        && sortedPlaces.get(i).getPlaceStartTime() > sortedPlaces.get(j).getPlaceStartTime()) {
                    Collections.swap(sortedPlaces, i, j);
                }
            }
        }
    }

}
