import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * This test ensures that getUser() method returns with the right User for a User that are present in the database.
     */
    @Test
    void getValidUser() {
        String[] user = new String[] {"Amy", "Smith"};
        boolean testResults;

        User result = Driver.getUser(user[0], user[1]);

        assert result != null;
        testResults = result.firstName.equals(user[0]) && result.lastName.equals(user[1]);

        if (testResults) {
            System.out.println("GetValidUser: PASSED");
        } else {
            System.out.println("GetValidUser: FAILED");
        }
    }

    /**
     * This test ensures that getUser() method returns with null for a User that does not exist.
     */
    @Test
    void getNullUser() {
        String[] user = new String[] {"Dave", "Watson"};

        User result = Driver.getUser(user[0], user[1]);

        if (result == null) {
            System.out.println("GetNullUser: Passed");
        } else {
            System.out.println("GetNullUser: FAILED");
        }
    }
}