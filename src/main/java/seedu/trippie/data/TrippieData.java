package seedu.trippie.data;

import seedu.trippie.Storage;

import java.util.ArrayList;
import java.util.List;

public class TrippieData {
    private Storage storage;
    private int defaultTripIndex;
    private List<Trip> tripList;
    private int currentTripIndex;
    private Trip currentTrip = null;

    public TrippieData(Storage storage) {
        this.tripList = new ArrayList<>();
        this.storage = storage;
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

    public void setDefaultTripIndex(int index) {
        this.defaultTripIndex = index;
    }

    public Trip getCurrentTrip() {
        if (this.currentTrip == null) {
            try {
                this.currentTrip = tripList.get(this.defaultTripIndex);
            } catch (IndexOutOfBoundsException | NullPointerException p) {
                return null;
            }
        }
        return this.currentTrip;
    }

    public void setCurrentTripIndex(int index) {
        this.currentTripIndex = index;
    }

    public void loadCurrentTripFromFile() {
        if (currentTripIndex < this.getTripList().size()) {
            currentTrip = this.getTripList().get(currentTripIndex);
            Trip tempTrip = storage.loadTrip(currentTrip);
            currentTrip.setPlaceList(tempTrip.getPlaceListObject());
            currentTrip.setExpenseList(tempTrip.getExpenseListObject());
            currentTrip.getExpenseListObject().setBudgetValue(tempTrip.getExpenseListObject().getBudgetValue());
        }
    }
}
