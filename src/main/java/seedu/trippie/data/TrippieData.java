package seedu.trippie.data;

import seedu.trippie.Storage;
import seedu.trippie.exception.TrippieException;

import java.util.ArrayList;
import java.util.List;

public class TrippieData {
    private Storage storage;
    private int defaultTripIndex;
    private List<Trip> tripList;
    private Trip currentTrip = null;

    private void updateTripIndices() {
        for (Trip t: tripList) {
            t.setIndex(tripList.indexOf(t));
        }
    }

    public TrippieData(Storage storage) {
        this.tripList = new ArrayList<>();
        this.storage = storage;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public boolean isTripListEmpty() {
        return tripList.isEmpty();
    }

    public void addTrip(Trip trip) {
        tripList.add(trip);
        updateTripIndices();
    }

    public Trip getTripFromIndex(int index) {
        return tripList.get(index);
    }

    public void removeTripFile(String name) {
        storage.deleteTripFile(name);
    }

    public Trip removeTripFromIndex(int index) {
        Trip t = tripList.remove(index);
        storage.deleteTripFile(t.getName());
        updateTripIndices();
        this.setCurrentTripFromIndex(-1);
        return t;
    }

    public int getTripListSize() {
        return tripList.size();
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

    public void setTripList(List<Trip> tripList) {
        this.tripList = new ArrayList<>(tripList);
    }

    public void setDefaultTripIndex(int index) {
        this.defaultTripIndex = index;
    }

    /**
     * Sets the current trip index to the specified trip index.
     * If index given is -1, then set current trip to null.
     * @param index specified trip index to point to.
     */
    public void setCurrentTripFromIndex(int index) {
        if (index == -1) {
            this.currentTrip = null;
        } else {
            this.currentTrip = this.tripList.get(index);
            System.out.println("Current trip is set to '" + this.currentTrip.getName() + "'.");
        }
    }

    // Implemented with reference to
    // https://www.rgagnon.com/javadetails/java-check-if-a-filename-is-valid.html
    public boolean doesTripNameExist(String name) {
        for (Trip trip: tripList) {
            if (trip.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void loadCurrentTripFromFile() {
        if (currentTrip.getIndex() < this.getTripListSize()) {
            Trip tempTrip = storage.loadTripFromFile(currentTrip);
            assert tempTrip != null;
            currentTrip.setPlaceList(tempTrip.getPlaceListObject());
            currentTrip.setExpenseList(tempTrip.getExpenseListObject());
        }
    }

    public String list() {
        String list = "";
        for (Trip trip : tripList) {
            assert trip != null;
            int maxDay = trip.getMaxDay();

            if (maxDay == 0) {
                list = list.concat(
                        (trip.getIndex() + 1) + ". " + trip.getName() + " " + "[No places or expenses added yet]" + "\n"
                );
            } else {
                boolean plural = maxDay != 1;
                String dayWord = plural ? "Days" : "Day";

                list = list.concat(
                        (trip.getIndex() + 1) + ". " + trip.getName() + " [" + trip.getMaxDay() + " " + dayWord + "]\n"
                );
            }
        }

        return list;
    }
}
