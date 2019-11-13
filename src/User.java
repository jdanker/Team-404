import java.util.ArrayList;
import java.util.Scanner;


public class User {

    // Class properties
    protected long ID;
    protected long accountID;
    protected String phoneNumber;
    protected double fines;
    protected String accountType;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String address;
    protected ArrayList<Media> checkedOut;
    Scanner input = new Scanner(System.in);

    /**
     * This method is the default constructor for the User Abstract Class
     *
     * @param firstName   is the String value for the User object's first name.
     * @param lastName    is the String value for the User object's last name.
     * @param email       is the String value for the User object's email.
     * @param address     is the String value for the User object's address.
     * @param phoneNumber is the String value for the User object's phone number.
     * @param ID          is the long value for the User ID number. It is unique to this individual
     * @param accountId   is the long value for the User ID number. It is unique to this individuals family members
     * @param fines       is the long value for total fines due by this User
     */
    public User(
            long ID,
            String firstName,
            String lastName,
            String address,
            String email,
            String phoneNumber,
            long accountId,
            String type,
            double fines,
            ArrayList<Media> checkedOut
    ) {
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

    public String getAccountType() {
        return this.accountType;
    }

    public double getFines() {
        return this.fines;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }


    public void setFines(double fines) {
        this.fines = fines;
    }

    /**
     * This method adds a Media object to the User's Media List. It decrements the number of
     * available copies.
     *
     * @param media is the Media object to be added.
     */
    public void checkoutMedia(Media media) {

        /**
         * This method removes the Media object from the User's Media List and increments the number
         * of available copies.
         * @param media is the Media object to be returned.
         */

        System.out.println("Enter the type of media to be checked out:");
        String in = input.nextLine();

        switch (in) {
            case "Book":
                System.out.println("Enter new book title to be checked out");
                String bookCheckout = input.nextLine();
                if (Books.bookList.contains(bookCheckout)) {
                    long num = media.getNumCopies();
                    num -= 1;
                    media.setNumCopies(num);
                    checkedOut.add(media);

                    System.out.println("------------" + bookCheckout + "has been successfully checked out!--------------");
                } else {
                    System.out.println(bookCheckout + " is not in the library. Please enter a different book to be checked out");
                }
                break;

            case "DVD":
                System.out.println("Enter the title of the DVD to be checked out:");
                String dvdCheckout = input.nextLine();
                if (DVDs.dvdsList.contains(dvdCheckout)) {
                    long num = media.getNumCopies();
                    num -= 1;
                    media.setNumCopies(num);
                    checkedOut.add(media);
                    System.out.println("------------" + dvdCheckout + "has been successfully checked out!--------------");
                } else {
                    System.out.println(dvdCheckout + " is not in the library. Please enter a different book to be checked out");
                }
                break;

            case "Magazine":
                System.out.println("Enter the title of the magazine to be checked out:");
                String magazineCheckout = input.nextLine();
                if (Magazines.magazineList.contains(magazineCheckout)) {
                    long num = media.getNumCopies();
                    num -= 1;
                    media.setNumCopies(num);
                    checkedOut.add(media);
                    System.out.println("------------" + magazineCheckout + "has been successfully checked out!--------------");
                } else {
                    System.out.println(magazineCheckout + " is not in the library. Please enter a different book to be checked out");
                }
                break;
        }
    }
}