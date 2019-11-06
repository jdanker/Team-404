import java.util.ArrayList;

public class User {

    // Class properties
    protected long ID;
    protected long accountID;
    protected String phoneNumber;
    protected int checkoutLimit;
    protected long fines;
    protected String accountType;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
    protected String DOB;

    protected ArrayList<Media> mediaList;

    /**
     * This method is the default constructor for the User Abstract Class
     * @param firstName is the String value for the User object's first name.
     * @param lastName is the String value for the User object's last name.
     * @param email is the String value for the User object's email.
     * @param address is the String value for the User object's address.
     * @param DOB is the String value for the User object's date of birth.
     * @param phoneNumber is the int value for the User object's phone number.
     */
    public User (
            long ID,
            String firstName,
            String lastName,
            String address,
            String email,
            String phoneNumber,
            long accountId,
            String type,
            long fines) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fines = fines;
        this.accountID = accountId;
        this.accountType = type;
    }

    // TODO: Should this be handled by the driver? It could also be a boolean, and if it returns true (login successful), continue. Otherwise loop back and try again
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
