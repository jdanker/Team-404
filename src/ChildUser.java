import java.util.*;

public class ChildUser extends User {

    private long balance;
    /**
     * This method is the default constructor for the User Abstract Class
     *
     * @param firstName   is the String value for the User object's first name.
     * @param lastName    is the String value for the User object's last name.
     * @param email       is the String value for the User object's email.
     * @param address     is the String value for the User object's address.
     * @param DOB         is the String value for the User object's date of birth.
     * @param phoneNumber is the int value for the User object's phone number.
     */
    public ChildUser(long ID, String firstName, String lastName, String email, String address,
                     long DOB, String phoneNumber, long accountID, String type, long fines) {
        super(ID, firstName, lastName, address, email, phoneNumber, accountID, type, fines, new ArrayList<Media>());
        this.balance = (long) 0.0;
    }

    /**
     * Method to make a childUser a standardUser when they turn 18
     */
}
