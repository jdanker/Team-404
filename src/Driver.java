import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    // Class Properties

    /**
     * This method is the main driver method for the program.
     * @param args is the String array to take in values.
     */
    public static void main(String[] args) {
        // Initializing required classes and properties.
        Scanner userInput = new Scanner(System.in);
        boolean isDone = false;
        boolean isLoggedIn = false;

        // The current user logged in.
        User selectedUser;

        UserInterface.printGreet();

        while(!isDone) {

            UserInterface.printWelcomeMenu();
            System.out.print("Select an option to proceed: ");
            int input = userInput.nextInt();

            switch (input) {
                case 1:
                    // Gathers the username and password from the User.
                    System.out.print("Please enter your username: ");
                    String un = userInput.next();

                    System.out.print("Please enter your password: ");
                    String pw = userInput.next();

                    // Checks if user is in the database.
                    // TODO: Implement Login method.

                    selectedUser = login(un, pw);
                    isLoggedIn = selectedUser != null;

                    // Runs the appropriate menu according to account type or tell the user the login is invalid.
                    if (!isLoggedIn) {
                        System.out.println("The username or password entered is invalid.");
                    } else {
                        System.out.println("You are now logged in. Let's run something.");
                    }
                    UserInterface.printDashes();
                    break;

                case 2:
                    // TODO: somehow make the new user get stored in a JSON file
                    System.out.println("Please enter your first name:");
                    String firstName = userInput.next();

                    System.out.println("Please enter your last name:");
                    String lastName = userInput.next();

                    System.out.println("Please enter your email address:");
                    String email = userInput.next();

                    System.out.println("Please enter your local address:");
                    String address = userInput.next();

                    System.out.println("Please enter your Date of Birth:");
                    String DOB = userInput.next();

                    System.out.println("Please enter your phone number:");
                    String phoneNumber = userInput.next();

                    // Develops an unique user ID from the number of user in the system.
                    ArrayList<User> users = JSONReadWrite.loadUsers();
                    assert users != null;
                    int idNum = users.size() +1;

                    StandardUser newUser = new StandardUser(idNum, firstName, lastName, email, address, phoneNumber,idNum,"S", 0);
                    System.out.println("New User, " + newUser.firstName + ", has been created.");
                    System.out.println("Your password is " + newUser.lastName + ".");
                    UserInterface.printDashes();
                    break;

                case 3:
                    // Exits the Program.
                    System.out.println("Thank you for choosing Team-404 Regional.");
                    isDone = true;
                    break;

                default:
                    System.out.println("Invalid Input. Please select a valid value: (1 - 3)");
            }
        }
    }

    /**
     * This method checks the user's username and password against the user collection from
     * the database.
     * @param userName is a string value that represents the user's first name.
     * @param password is a string value that represents the user's last name.
     * @return an User object.
     */
    private static User login(String userName, String password) {
        // Loads User ArrayList into a local ArrayList
        ArrayList<User> users = JSONReadWrite.loadUsers();

        // Makes sure the user list is not empty.
        assert users != null;

        // Checks if the user name and password matches existing users.
        for (User user : users) {
            if (user.firstName.equals(userName) && user.lastName.equals(password)) {
                return user;
            }
        }
        // If user was not found, it returns null.
        return null;
    }

    private static void runUserMenu(String type) {
        switch (type) {
            case "L":
                // Run Admin Menu sequence.
                break;

            case "T":
                // Run Teacher Menu sequence.
                break;

            case "C":
                // Run Child User Menu sequence.
                break;

            default:
                // Run standard user sequence.
        }
    }
}
