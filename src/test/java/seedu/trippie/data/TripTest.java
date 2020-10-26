package seedu.trippie.data;

import org.junit.jupiter.api.Test;
import seedu.trippie.exception.TrippieException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TripTest {

    @Test
    void tripConstructor_validInputs_success() throws ParseException, TrippieException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Trip trip = new Trip(1, "Trip name", df.parse("01-01-2020"));

        assertEquals(trip.getIndex(), 1);
        assertEquals(trip.getName(), "Trip name");
        assertEquals(df.format(trip.getStartDate()), "01-01-2020");
    }

    @Test
    void tripConstructor_invalidName_trippieExceptionThrown() {
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Trip trip = new Trip(-1, "Trip name", df.parse("01-01-2020"));

            assertEquals(trip.getIndex(), 1);
            assertEquals(trip.getName(), "Trip name");
            assertEquals(df.format(trip.getStartDate()), "01-01-2020");
        } catch (TrippieException e) {
            assertEquals(e.getMessage(), "Index out of bounds");
        } catch (ParseException p) {
            fail();
        }
    }

    @Test
    void tripConstructor_invalidIndex_trippieExceptionThrown() {
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Trip trip = new Trip(1, "", df.parse("01-01-2020"));

            assertEquals(trip.getIndex(), 1);
            assertEquals(trip.getName(), "Trip name");
            assertEquals(df.format(trip.getStartDate()), "01-01-2020");
        } catch (TrippieException e) {
            assertEquals(e.getMessage(), "Trip name should not be empty");
        } catch (ParseException p) {
            fail();
        }
    }

    @Test
    void getSetExpenseListObject_validInputs_success() {
        Trip trip = new Trip();
        ExpenseList expenseList = new ExpenseList();

        assertNotEquals(trip.getExpenseListObject(), expenseList);
        trip.setExpenseList(expenseList);
        assertEquals(trip.getExpenseListObject(), expenseList);
    }

    @Test
    void getSetPlaceListObject_validInputs_success() {
        Trip trip = new Trip();
        PlaceList placeList = new PlaceList();

        assertNotEquals(trip.getPlaceListObject(), placeList);
        trip.setPlaceList(placeList);
        assertEquals(trip.getPlaceListObject(), placeList);
    }

    @Test
    void getMaxDay() {
    }

    @Test
    void testToString() {
    }
}