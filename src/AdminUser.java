import java.util.ArrayList;

public class AdminUser extends User {

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

  public AdminUser(Long ID, String firstName, String lastName, String email, String address, String DOB, String phoneNumber, Long accountID) {
    super(ID, firstName, lastName, address, email, phoneNumber, accountID, "L", 0, new ArrayList<Media>()); //L type is for librarian
  }

  /**
  * These methods adds a piece of media to the library
  * @param media is the object to be added
  */
  public void AddMagazine(magazine media) {
    JSONReadWrite.addMagazine(media);
    System.out.println(media + " has been added to the library");
  }

  public void AddBook(book book) {
    JSONReadWrite.addBook(book);
    System.out.println(book + " has been added to the library");
  }

  public void AddItem(DVD dvd) {
    JSONReadWrite.addDVD(dvd);
  }

  /**
   * This method adds a fee to a user's account
   * @param fee is the fee to be applied to the account
   * @param user is the User object the fee will be added to.
   */
  public void AddFees(int fee, User user) {
    user.fines += fee;
    System.out.println("A fee of "+ fee + " has been added");
  }
}
