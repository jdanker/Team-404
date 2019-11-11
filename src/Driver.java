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

                    String type = selectedUser.getAccountType();
                    runUserMenu(selectedUser, type);

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

                    userInput.nextLine();
                    System.out.println("Please enter your first name:");
                    String firstName = userInput.nextLine();

                    System.out.println("Please enter your last name:");
                    String lastName = userInput.nextLine();

                    System.out.println("Please enter your email address:");
                    String email = userInput.nextLine();

                    System.out.println("Please enter your local address:");
                    String address = userInput.nextLine();

                    System.out.println("Please enter your Date of Birth:");
                    String DOB = userInput.nextLine();

                    System.out.println("Please enter your phone number:");
                    String phoneNumber = userInput.nextLine();

                    // Develops an unique user ID from the number of user in the system.
                    //ArrayList<User> users = JSONReadWrite.loadUsers();
                    //assert users != null;
                    int idNum = (int) (Math.random()*10);

                    StandardUser newUser = new StandardUser(idNum, firstName, lastName, email, address, phoneNumber,idNum,"S", 0);
                    JSONReadWrite.addUser(newUser);
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

//    TODO: @thel Flesh out menu tree for the driver
    private static void runUserMenu(User selectedUser, String type) {
        switch (type) {
            case "L": //Admin user "L" for librarian
                // Run Admin Menu
                runAdminMenu((AdminUser) selectedUser);
                break;
            case "T": //Teacher user "T"
                runTeacherMenu((TeacherUser) selectedUser);
            case "C": //ChildUser "C"
                runChildMenu((ChildUser) selectedUser);
            case "P": //StandardUser "P"
                // Run Teacher Menu sequence.
                runTeacherMenu((TeacherUser) selectedUser);
                break;
            //TODO add cases for StandardUser and ChildUser
            default:
                System.exit(0);
        }
    }

    private static void runStandardMenu(User user)   {
        Scanner input = new Scanner(System.in);
        boolean loggedOut = false;

        while (!loggedOut)  {
            UserInterface.printStandardMenu();
            int userInput = input.nextInt();

            switch (userInput)  {
                case 1:
                    System.out.println("Media List: ");
                case 2:
                    System.out.println("Holds: ");
                case 3:
                    System.out.println("Account Balance: " + user.getFines());
                case 4:
                    System.out.println("Enter the name of the media to check out: ");
                case 5:
                    System.out.println("Enter the name of the media to be checked in: ");
                case 6:
                    System.out.println("Register Child ");
                case 7:
                    System.out.println("Logging out...");
                default:
                    System.out.println("Invalid Input. Please select a valid value");
            }
        }
    }
    private static void runChildMenu(User user)   {
        Scanner input = new Scanner(System.in);
        boolean loggedOut = false;

        while (!loggedOut)  {
            UserInterface.printChildMenu();
            int userInput = input.nextInt();

            switch (userInput)  {
                case 1:
                    System.out.println("Media List: ");
                case 2:
                    System.out.println("Holds: ");
                case 3:
                    System.out.println("Enter the media to be checked in");
                case 4:
                    System.out.println("Logging out...");
                default:
                    System.out.println("Invalid Input. Please select a valid value");
            }
        }
    }

    private static void runTeacherMenu(TeacherUser user)    {
        Scanner input = new Scanner(System.in);
        boolean loggedOut = false;

        while (!loggedOut)  {
            UserInterface.printTeacherMenu();
            int userInput = input.nextInt();
            String title;

            switch(userInput)   {
                case 1:
                    System.out.println("Media List: ");

                case 2:
                    System.out.println("Holds: ");

                case 3:
                    System.out.println("Account Balance:" );

                case 4:
                    System.out.println("Enter the name of the media to be checked out: ");
                case 5:
                    System.out.println("Enter the name of the media to be checked in:");
                case 6:
                    System.out.println("Logging out...");
                    loggedOut = true;
                default:
                    System.out.println("Invalid Input. Please select a valid value");

            }
        }
    }

    private static void runAdminMenu(AdminUser user) {
        Scanner input = new Scanner(System.in);
        boolean loggedOut = false;

        while (!loggedOut) {
            UserInterface.printAdminMenu();
            int userinput = input.nextInt();

            switch (userinput) {
                case 1:
                    System.out.println("Please specify the ID of the new media:");
                    long id = input.nextLong();

                    System.out.println("Please specify the title of the new media:");
                    String title = input.next();

                    System.out.println("Please specify the year of the new media:");
                    long year = input.nextLong();

                    System.out.println("Please specify the genre of the new media:");
                    String genre = input.next();

                    System.out.println("Please specify if the new media is a new release:");
                    boolean newRelease = input.nextBoolean();

                    System.out.println("Please specify how many copies of the new media is available:");
                    long amount = input.nextLong();

                    //Media newMedia = new book(id, title, year, genre, newRelease, amount);

                    //user.AddItem();
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println(user.firstName + " is now logged out.");
                    loggedOut = true;
                    UserInterface.printDashes();
                    break;

                default:
                    System.out.println("Invalid Input. Please select a valid value: (1 - 3)");
            }
        }
    }
}
