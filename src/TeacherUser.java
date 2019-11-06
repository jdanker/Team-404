import java.util.ArrayList;


public class TeacherUser extends User {

    private long balance;
    /**
     * This method is the default constructor for the User Abstract Class
     *
     * @param ID          is the long value for the USer object's ID
     * @param firstName   is the String value for the User object's first name.
     * @param middleName  is the String value for the User object's middle name.
     * @param lastName    is the String value for the User object's last name.
     * @param email       is the String value for the User object's email.
     * @param address     is the String value for the User object's address.
     * @param DOB         is the String value for the User object's date of birth.
     * @param phoneNumber is the int value for the User object's phone number.
     */

    public TeacherUser(long ID, String firstName, String lastName, String address,
                       String email, String DOB, String phoneNumber, long accountID, long fines)    {
        super(ID, firstName, lastName, address, email, phoneNumber, accountID, "T", fines, new ArrayList<>());

    }
}
