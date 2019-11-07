import java.util.ArrayList;

public class StandardUser extends User {

    // Class Properties
    private int balance;
    private ArrayList<Media> holds;
    private ArrayList<User> children;

    /**
     * This method is the default constructor for the User Abstract Class
     *
     * @param firstName   is the String value for the User object's first name.
     * @param lastName    is the String value for the User object's last name.
     * @param email       is the String value for the User object's email.
     * @param address     is the String value for the User object's address.
     * @param phoneNumber is the int value for the User object's phone number.
     * @param accountID is the int value for the User object's account ID number.
     */
    public StandardUser(long ID, String firstName, String lastName, String address, String email, String phoneNumber, long accountID, String type, long fines) {
        super(ID, firstName, lastName, address, email, phoneNumber, accountID, type, fines, new ArrayList<Media>());
        this.holds = new ArrayList<>();
        this.children = new ArrayList<>();
        this.accountType = "S";
    }

    /**
     * This method adds a Media object to the user's hold list.
     * @param media is the Media object.
     */
    public void addhold (Media media) {
        this.holds.add(media);
        System.out.println("A hold request for " + media.title + " has been placed.");
    }

    /**
     * This method creates a ChildUser object and stores it in the standardUser object's
     * children array list.
     * @param firstName   is the String value for the User object's first name.
     * @param middleName  is the String value for the User object's middle name.
     * @param lastName    is the String value for the User object's last name.
     * @param email       is the String value for the User object's email.
     * @param address     is the String value for the User object's address.
     * @param DOB         is the String value for the User object's date of birth.
     * @param phoneNumber is the int value for the User object's phone number.
     */
    public void addChild(String firstName, String middleName, String lastName, String email, String address, String DOB, int phoneNumber) {
        // TODO: Add info to Child constructor.
        User child = null;
        this.children.add(child);

    }

    /**
     * This method takes a positive amount and apply it to the user's account balance.
     * @param amount is an int value to be subtracted from the balance.
     * @return an int value that represents the user's balance.
     */
    public int payFees( int amount) {
        // Checks if the user's balance is already zero.
        if (this.fines == 0){
            System.out.println("You have a $0.00 balance");
            return 0;
        }

        // Checks if the amount is a positive value.
        if (amount < 0) {
            System.out.println("Invalid input. The amount must be positive value.");
        }

        return (int)this.fines - amount;
    }
}
