package seedu.trippie.data;

import java.util.ArrayList;
import java.util.List;

public class PlaceList {
    private List<Place> placeList;

    public PlaceList() {
        this.placeList = new ArrayList<>();
    }

    public PlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = new ArrayList<>(placeList);
    }

    public int getMaxDay() {
        return placeList.get(placeList.size() - 1).getPlaceDay();
    }
}
