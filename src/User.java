import java.util.ArrayList;
import java.util.Scanner;


public class User {

    // Class properties
    protected long ID;
    protected long accountID;
    protected String phoneNumber;
    protected int checkoutLimit;
    protected double fines;
    protected String accountType;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
    protected String DOB;
    protected ArrayList<Media> checkedOut;
    Scanner input = new Scanner(System.in);

    /**
     * This method is the default constructor for the User Abstract Class
     * @param firstName is the String value for the User object's first name.
     * @param lastName is the String value for the User object's last name.
     * @param email is the String value for the User object's email.
     * @param address is the String value for the User object's address.
     * @param phoneNumber is the String value for the User object's phone number.
     * @param ID is the long value for the User ID number. It is unique to this individual
     * @param accountId is the long value for the User ID number. It is unique to this individuals family members
     * @param fines is the long value for total fines due by this User
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
            double fines,
            ArrayList<Media> checkedOut) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fines = fines;
        this.accountID = accountId;
        this.accountType = type;
        this.checkedOut = checkedOut;
    }

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
    public void checkoutMedia (Media media) {

        /**
         * This method removes the Media object from the User's Media List and increments the number
         * of available copies.
         * @param media is the Media object to be returned.
         */

        System.out.println("Enter new book title to be checked out");
        String bookCheckout = input.next();
        if(Books.bookList.contains(bookCheckout)){
            long num = media.getNumCopies();
            num -=1;
            media.setNumCopies(num);
            checkedOut.add(media);

            System.out.println("------------"+bookCheckout + "has been successfully checked out!--------------");
        }
        else{
            System.out.println(bookCheckout + " is not in the library. Please enter a different book to be checked out");
        }

    }
        public void checkIn (Media media){
            System.out.println("Enter new book title to be checked in");
            String bookCheckout = input.next();
            if(Books.bookList.contains(bookCheckout)){
                long num = media.getNumCopies();
                num +=1;
                media.setNumCopies(num);
                checkedOut.remove(media);

                System.out.println("------------"+bookCheckout + "has been successfully checked in! --------------");
            }
            else{
                System.out.println(bookCheckout + " is not in the library. Please enter a different book to be checked in");
            }
        }
    /**
     * This method resets the checkout time for the media object.
     * @param media is the Media object whose time will be reset.
     */
    public void renewMedia (Media media) {}

    public String getAccountType()  {
        return this.accountType;
    }

    public double getFines() {
        return this.fines;
    }
}
