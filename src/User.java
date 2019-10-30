import java.util.ArrayList;

public abstract class User {

    // Class properties
    private int accountID;
    private int phoneNumber;
    private int checkoutLimit;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String address;
    private String DOB;
    private ArrayList<Media> mediaList;

    /**
     * This method is the default constructor for the User Abstract Class
     * @param firstName is the String value for the User object's first name.
     * @param middleName is the String value for the User object's middle name.
     * @param lastName is the String value for the User object's last name.
     * @param email is the String value for the User object's email.
     * @param address is the String value for the User object's address.
     * @param DOB is the String value for the User object's date of birth.
     * @param phoneNumber is the int value for the User object's phone number.
     */
    public User (
            String firstName,
            String middleName,
            String lastName,
            String email,
            String address,
            String DOB,
            int phoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;

        // TODO: Implement a method to assign a user an unique user account number.
    }

    // TODO: Should this be handled by the driver?
    public void login(String email, String password) {}

    /**
     * This method returns the user to the "Welcome" screen.
     */
    public void logout() {}

    /**
     * This method takes in a title (Subject to change) and searches the database for corresponding media
     * and stores the results in an ArrayList.
     * @param title is the String value to be searched.
     * @return an ArrayList of Media objects.
     */
    public ArrayList<Media> Search(String title) {
        return null;
    }

    /**
     * This method adds a Media object to the User's Media List. It decrements the number of
     * available copies.
     * @param media is the Media object to be added.
     */
    public void checkoutMedia (Media media) {}

    /**
     * This method removes the Media object from the User's Media List and increments the number
     * of available copies.
     * @param media is the Media object to be returned.
     */
    public void checkIn (Media media) {}

    /**
     * This method resets the checkout time for the media object.
     * @param media is the Media object whose time will be reset.
     */
    public void renewMedia (Media media) {}
}
