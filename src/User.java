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

    public void login(String email, String password) {}

    public void logout() {}

    public ArrayList<Media> Search(String title) {
        return null;
    }

    public void checkoutMedia (String title) {}

    public void checkIn (String title) {}

    public void renewMedia (String title) {}

    public void AddHold (String title) {}
}
