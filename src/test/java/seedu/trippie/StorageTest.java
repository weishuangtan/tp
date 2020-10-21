package seedu.trippie;

import org.junit.jupiter.api.Test;
import seedu.trippie.data.TrippieData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;

class StorageTest {

    private Scanner createSampleMasterFile() {

        String sampleMasterFileText = "DEFAULT 6\n"
               + "0,Chigago run,01-01-2021\n"
               + "1,Jakarta Fest,01-02-2021\n"
               + "2,Malaysia,20-08-2021\n"
               + "3,Malaysia,20-02-2020\n"
               + "4,Australia,20-12-2020\n"
               + "5,America,20-11-2020\n"
               + "6,Africa,04-03-2021\n";

        return new Scanner(sampleMasterFileText);
    }

    @Test
    public void loadMasterFileList_sampleMasterFile_success() {
        Scanner sc = createSampleMasterFile();
        Storage storage = new Storage();
        TrippieData data = new TrippieData(storage);
        storage.loadMasterFile(sc, data);

        String expectedTripListString = "0. 1 Day - Chigago run\n"
                + "1. 1 Day - Jakarta Fest\n"
                + "2. 1 Day - Malaysia\n"
                + "3. 1 Day - Malaysia\n"
                + "4. 1 Day - Australia\n"
                + "5. 1 Day - America\n"
                + "6. 1 Day - Africa\n";

        assertEquals(expectedTripListString, data.list());
    }
}