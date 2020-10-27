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
        if (placeList.size() == 0) {
            return 0;
        }
        int maxDay = 0;
        for (Place place: placeList) {
            if (place.getPlaceDay() > maxDay) {
                maxDay = place.getPlaceDay();
            }
        }
        return maxDay;
    }
}
