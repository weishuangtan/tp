package seedu.trippie.command;

import seedu.trippie.ExpenseList;
import seedu.trippie.Place;
import seedu.trippie.PlaceList;
import seedu.trippie.Ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPlacesCommand extends Command{

    public ListPlacesCommand() {

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
        for (int i = 1; i <= maxDay; i++) {
            System.out.println("DAY " + i + ": ");
            for (Place place : places) {
                if (place.getPlaceDay() == i) {
                    System.out.println(place.getPlace());
                }
            }
            System.out.println(System.lineSeparator());
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
