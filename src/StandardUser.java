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
     * @param middleName  is the String value for the User object's middle name.
     * @param lastName    is the String value for the User object's last name.
     * @param email       is the String value for the User object's email.
     * @param address     is the String value for the User object's address.
     * @param DOB         is the String value for the User object's date of birth.
     * @param phoneNumber is the int value for the User object's phone number.
     */
    public StandardUser(String firstName, String middleName, String lastName, String email, String address, String DOB, int phoneNumber) {
        super(firstName, middleName, lastName, email, address, DOB, phoneNumber);
    }

    public void addhold (Media media) {
        this.holds.add(media);
        System.out.println("A hold request for " + media.title + " has been placed.");
    }

    public int addChild(String firstName, String middleName, String lastName, String email, String address, String DOB, int phoneNumber) {
        // TODO: Add info to Child constructor.
        User child = null;
        this.children.add(child);
        
        // TODO: Return an unique User account number.
        return 0;
    }

    public int payFees( int amount) {
        // Checks if the user's balance is already zero.
        if (this.balance == 0){
            System.out.println("You have a $0.00 balance");
            return 0;
        }

        // Checks if the amount is a positive value.
        if (amount < 0) {
            System.out.println("Invalid input. The amount must be positive value.");
        }

        return balance - amount;
    }
}
