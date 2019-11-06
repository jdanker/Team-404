import java.util.*;

public class ChildUser extends User {

    private long balance;
    /**
     * This method is the default constructor for the User Abstract Class
     *
     * @param firstName   is the String value for the User object's first name.
     * @param middleName  is the String value for the User object's middle name.
     * @param lastName    is the String value for the User object's last name.
     * @param email       is the String value for the User object's email.
     * @param address     is the String value for the User object's address.
     * @param DOB         is the String value for the User object's date of birth.
     * @param phoneNumber is the int value for the User object's phone number.
     */
    public ChildUser(String firstName, String middleName, String lastName, String email, String address, String DOB, int phoneNumber) {
        super(firstName, middleName, lastName, email, address, DOB, phoneNumber);
        this.balance = (long) 0.0;
    }
    /**
     * Method to make a childUser a standardUser when they turn 18
     */
    public User TransformAccount()  {
        return null;
    }
}
