package seedu.trippie.data;

import java.util.ArrayList;
import java.util.List;

public class TripList {
    private List<Trip> tripList;

    public TripList() {
        tripList = new ArrayList<>();
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = new ArrayList<>(tripList);
    }

    public String list() {
        String list = "";
        for (Trip trip : tripList) {
            boolean plural = trip.getMaxDay() > 1;
            String dayWord = plural ? "Days" : "Day";
            list = list.concat(
                    trip.getIndex() + ". " + trip.getMaxDay() + " " + dayWord + " - " + trip.getName() + "\n"
            );
        }

        return list;
    }
}
