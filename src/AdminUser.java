import java.util.ArrayList;

public class AdminUser extends user {

  public AdminUser(String firstName, String middleName, String lastName, String email, String address, String DOB, int phoneNumber) {
    super(firstName, middleName, lastName, email, address, DOB, phoneNumber);
  }

  public void AddItem(Media media) {
    this.MediaList.add(media);
    System.out.println(media + " has been added to the library");
  }

  public void AddFees(int fee) {
    this.Balance += fee;
    System.out.println("A fee of "+ fee + " has been added")
  }
}
