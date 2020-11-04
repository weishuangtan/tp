package seedu.trippie.data;

import org.junit.jupiter.api.Test;
import seedu.trippie.Storage;
import seedu.trippie.exception.TrippieException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrippieDataTest {

    @Test
    void list_singleTrip_success() throws TrippieException, ParseException {
        Storage storage = new Storage();
        TrippieData trippieData = new TrippieData(storage);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Trip trip = new Trip(0, "TripName", df.parse("01-01-2020"));

        trippieData.getTripList().add(trip);

        assertEquals("1. TripName [No places or expenses added yet]\n", trippieData.list());
    }

}