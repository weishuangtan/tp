package seedu.trippie;

public class Place {
    private final String name;
    private final String day;
    private final String time;

    public Place(String name, String day, String time) {
        this.name = name;
        this.day = day;
        this.time = time;
    }

    public String getPlaceName() {
        return name;
    }

    public String getPlaceDay() {
        return day;
    }

    public String getPlaceTime() {
        return time;
    }

    public String getPlace() {
        return getPlaceTime() + " " + getPlaceName();
    }
}
