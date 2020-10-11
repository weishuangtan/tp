package seedu.trippie;

import java.util.ArrayList;
import java.util.List;

public class PlaceList {
    private List<Place> placeList;

    public PlaceList() {
        placeList = new ArrayList<>();
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = new ArrayList<>(placeList);
    }
}
