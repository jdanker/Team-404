import java.util.Scanner;
public class Driver {
    // Class Properties
    private LoadMedia loadMedia = new LoadMedia();

    /**
     * This method is the main driver method for the program.
     * @param args is the String array to take in values.
     */
    public static void main(String[] args) {
        // Initializing required classes and properties.
        Scanner userInput = new Scanner(System.in);
        //LoadMedia loadMedia = new LoadMedia();
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
                    System.out.print("Please enter your username/ID: ");
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
                    // TODO: Implement Register new user method.
                    System.out.print("Enter your first name: ");
                    String fName = userInput.next();

                    System.out.print("Enter your middle name/initial: ");
                    String mName = userInput.next();

                    System.out.print("Enter your last name: ");
                    String lName = userInput.next();

                    System.out.print("Enter your primary email address: ");
                    String email = userInput.next();

                    System.out.print("Enter your primary mailing address: ");
                    String address = userInput.next();

                    System.out.print("Enter your birthday: ");
                    String bd = userInput.next();

                    System.out.print("Enter your primary phone number: ");
                    int phone = userInput.nextInt();

                    selectedUser = new StandardUser(fName, mName, lName, email, address, bd, phone);
                    // Add this to the database some how. Get unique user ID.

                    System.out.println("New user, " + selectedUser.firstName + ", has been created.");
                    UserInterface.printDashes();
                    break;

                case 3:
                    // TODO: Replace "Local Library" with actual library name.
                    System.out.println("Thank you for choosing Local Library.");
                    isDone = true;
                    break;

                default:
                    System.out.println("Invalid Input. Please select a valid value: (1 - 3)");
            }
        }
    }

    private static User login(String userName, String password) {
        // TODO: Once database can retrieve user data, check for user name match, then check for matching password.

        return null;
    }

    private static void runUserMenu(char type) {
        switch (type) {
            case 'L':
                // Run Admin Menu sequence.
                break;

            case 'T':
                // Run Teacher Menu sequence.
                break;

            case 'C':
                // Run Child User Menu sequence.
                break;

            default:
                // Run standard user sequence.
        }
    }
}
