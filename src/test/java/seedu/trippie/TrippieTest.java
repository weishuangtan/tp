package seedu.trippie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrippieTest {
    @Test
    public void addPlace(){
        Trippie main = new Trippie("abc");
        main.run();
    }
}