import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagazinesTest {

    @org.junit.jupiter.api.Test
    void printMagazines() {
    }

    @org.junit.jupiter.api.Test
    void searchMagazines() {
        String testMagazine = "Tiny Houses";
        int expectedIndex = 1;
        int actualIndex;

        actualIndex = Magazines.searchMagazines(testMagazine);

        if (actualIndex == expectedIndex) {
            System.out.println("searchMagazines: PASSED");
        } else {
            System.out.println("searchMagazines: FAILED");
        }

    }
}