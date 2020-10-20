package seedu.trippie;

import org.junit.jupiter.api.Test;
import seedu.trippie.data.Trip;
import seedu.trippie.data.TrippieData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class StorageTest {

    public static final String TEST_DIRECTORY = "trippie_data";
    public static final String MASTER_FILE_NAME = "trippie.txt";

    private File createSampleMasterFile() throws java.io.IOException {
        File sampleMasterFile = new File(TEST_DIRECTORY + File.separator + MASTER_FILE_NAME);
        sampleMasterFile.createNewFile();

        FileWriter fw = new FileWriter(sampleMasterFile, false);

        fw.append(
               "DEFAULT 6\n" +
               "0,Chigago run,01-01-2021\n" +
               "1,Jakarta Fest,01-02-2021\n" +
               "2,Malaysia,20-08-2021\n" +
               "3,Malaysia,20-02-2020\n" +
               "4,Australia,20-12-2020\n" +
               "5,America,20-11-2020\n" +
               "6,Africa,04-03-2021\n"
        );

        fw.close();

        return sampleMasterFile;
    }

    @Test
    public void loadMasterFileList_sampleMasterFile_success() throws java.io.IOException {
        File file = createSampleMasterFile();
        Files.createDirectories(Path.of(file.getPath()).getParent());

        Storage storage = new Storage();
        TrippieData data = new TrippieData(storage);
        storage.loadMasterFile(new Scanner(file), data);

        String expectedTripListString = "0. 1 Day - Chigago run\n" +
                "1. 1 Day - Jakarta Fest\n" +
                "2. 1 Day - Malaysia\n" +
                "3. 1 Day - Malaysia\n" +
                "4. 1 Day - Australia\n" +
                "5. 1 Day - America\n" +
                "6. 1 Day - Africa\n";

        assertEquals(expectedTripListString, data.list());
    }
}