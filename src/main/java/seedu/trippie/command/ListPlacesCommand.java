package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Place;
import seedu.trippie.data.TrippieData;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListPlacesCommand extends Command {

    private static final String FORMAT_ERROR_MESSAGE = "You typed in the incorrect format for [list /p] command! "
            + "Please try the following:\nFormat:\nlist /p\nlist /p /d DAY_INDEX";
    private static final String PARAMETER_ERROR_MESSAGE = "Please check that the index keyed in is a number.";

    private final int specifiedDay;

    public ListPlacesCommand(String userInput) throws TrippieInvalidArgumentException {
        specifiedDay = getSpecifiedDay(userInput);
    }

    public int getSpecifiedDay(String userInput) throws TrippieInvalidArgumentException {
        try {
            String[] specificDay = userInput.split("/p");
            if (specificDay.length == 1) {
                return -1;
            } else {
                String[] finalDay = specificDay[1].split("/d");
                return Integer.parseInt(finalDay[1].trim());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            throw new TrippieInvalidArgumentException(PARAMETER_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public void execute(Ui ui, TrippieData trippieData) {
        List<Place> places = trippieData.getCurrentTrip().getPlaceListObject().getPlaceList();
        Date date = trippieData.getCurrentTrip().getStartDate();

        if (places.size() == 0) {
            System.out.println("There is currently nothing in your place list. Why not add one?");
        } else if (specifiedDay == -1) {
            int listIndex = 1;
            int dayPointer = places.get(0).getPlaceDay();
            String currentDate = addDays(date, dayPointer - 1);
            System.out.println("DAY " + dayPointer + ": (" + currentDate + ")");
            for (Place place : places) {
                if (dayPointer != place.getPlaceDay()) {
                    dayPointer = place.getPlaceDay();
                    currentDate = addDays(date, dayPointer - 1);
                    System.out.println("DAY " + dayPointer + ": (" + currentDate + ")");
                }
                System.out.println("[" + listIndex + "] " + place.toString());
                listIndex++;
            }
        } else {
            String currentDate = addDays(date, specifiedDay - 1);
            System.out.println("DAY " + specifiedDay + ": (" + currentDate + ")");
            for (Place place : places) {
                if (place.getPlaceDay() == specifiedDay) {
                    System.out.println(place.toString());
                }
            }
        }
        trippieData.getCurrentTrip().getPlaceListObject().setPlaceList(places);
    }

    public String addDays(Date date, int day) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return sdf.format(cal.getTime());
    }

}
