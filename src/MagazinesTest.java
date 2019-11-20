import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagazinesTest {

    @org.junit.jupiter.api.Test
    void printMagazines() {
    }

    /**
     * This test ensures that searchMagazines can correctly find the specified magazine.
     */

    @org.junit.jupiter.api.Test
    void searchMagazinesValid() {
        String testMagazine = "Tiny Houses";
        int expectedIndex = 1;
        int actualIndex;

        actualIndex = Magazines.searchMagazines(testMagazine);

        if (actualIndex == expectedIndex) {
            System.out.println("searchMagazinesValid: PASSED");
        } else {
            System.out.println("searchMagazinesValid: FAILED");
        }

    }

    @org.junit.jupiter.api.Test
    void searchMagazinesInvalid() {
        String testMagazine = "Lego: Build Imagination";
        int expectedIndex = -1;
        int actualIndex;

        actualIndex = Magazines.searchMagazines(testMagazine);

        if (actualIndex == expectedIndex) {
            System.out.println("searchMagazinesInvalid: PASSED");
        } else {
            System.out.println("searchMagazinesInvalid: FAILED");
        }

    }
}