package seedu.trippie;

public class Place {
    private final String name;
    private final int day;
    private final int start;
    private final int end;

    public Place(String name, int day, int start, int end) {
        this.name = name;
        this.day = day;
        this.start = start;
        this.end = end;
    }

    public String getPlaceName() {
        return name;
    }

    public int getPlaceDay() {
        return day;
    }

    public int getPlaceStartTime() {
        return start;
    }

    public int getPlaceEndTime() {
        return end;
    }

    public String getPlace() {
        return String.format("%04d",getPlaceStartTime()) + " - " + String.format("%04d", getPlaceEndTime())
                + " " + getPlaceName();
    }
}
