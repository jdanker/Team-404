import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @BeforeEach
    void setup() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * This test ensures if a User use the checkoutMedia method
     * adds the specified book to the user's checkout ArrayList.
     */
    @Test
    void checkoutMediaBook() {
        Media testbook = new book(1, "The Cat in the Hat", 2000, "Children", "9780761119753", "Random House", "Dr. Seuss", 2, false, " ");
        User user = Driver.getUser("Deja", "Scott");

        assert user != null;
        int priorSize = user.checkedOut.size();
        user.checkoutMedia(testbook);
        int afterSize = user.checkedOut.size();

        if (priorSize < afterSize) {
            System.out.println("checkoutMediaBook: PASS");
        } else {
            System.out.println("checkoutMediaBook: FAILED");
        }
    }

    /**
     * This test ensures if a User use the checkoutMedia method
     * adds the specified magazine to the user's checkout ArrayList.
     */
    @Test
    void checkoutMediaMagazine() {
        Media testbook = new magazine(0, "Popular Machinics", 0, " "," ", 0, 2, 2, false, " " );
        User user = Driver.getUser("Deja", "Scott");

        assert user != null;
        int priorSize = user.checkedOut.size();
        user.checkoutMedia(testbook);
        int afterSize = user.checkedOut.size();

        if (priorSize < afterSize) {
            System.out.println("checkoutMediaMagazine: PASS");
        } else {
            System.out.println("checkoutMediaMagazine: FAILED");
        }
    }

    /**
     * This test ensures if a User use the checkoutMedia method
     * adds the specified DVD to the user's checkout ArrayList.
     */
    @Test
    void checkoutMediaDVD() {
        Media testbook = new DVD(0, "Top Gun", 0," ", " ", " ", 2, false, "");
        User user = Driver.getUser("Deja", "Scott");

        assert user != null;
        int priorSize = user.checkedOut.size();
        user.checkoutMedia(testbook);
        int afterSize = user.checkedOut.size();

        if (priorSize < afterSize) {
            System.out.println("checkoutMediaDVD: PASS");
        } else {
            System.out.println("checkoutMediaDVD: FAILED");
        }
    }
}
