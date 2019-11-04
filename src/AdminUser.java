import java.util.ArrayList;

public class AdminUser extends User {

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

  public AdminUser(String firstName, String middleName, String lastName, String email, String address, String DOB, int phoneNumber) {
    super(firstName, middleName, lastName, email, address, DOB, phoneNumber);

  }

  /**
  * This method adds a piece of media to the library
  * @param media is the object to be added
  */
  public void AddItem(Media media, ArrayList<Media> MediaList) {
    MediaList.add(media);
    System.out.println(media + " has been added to the library");
  }

  /**
  * This method adds a fee to a user's account
  * @param fee is the fee to be applied to the account
  */
  public void AddFees(int fee) {
    this.Balance += fee;
    System.out.println("A fee of "+ fee + " has been added")
  }
}
