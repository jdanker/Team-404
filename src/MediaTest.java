import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaTest {

    @Test
    void getID() {
        long id;
        DVD dvd = new DVD(1234, "a dvd", 2000, "action", "none", "director", 3, false, "it's great");
        id = dvd.getID();
        assertEquals(1234, id);
    }

    @Test
    void getTitle() {
        String title;
        DVD dvd = new DVD(1234, "a dvd", 2000, "action", "none", "director", 3, false, "it's great");
        title = dvd.getTitle();
        assertEquals("a dvd", title);
    }

    @Test
    void getNumCopies() {
        long numCopies;
        DVD dvd = new DVD(1234, "a dvd", 2000, "action", "none", "director", 3, false, "it's great");
        numCopies = dvd.getNumCopies();
        assertEquals(3, numCopies);
    }
}