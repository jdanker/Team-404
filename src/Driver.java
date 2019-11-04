import java.util.Scanner;
public class Driver {
    // Class Properties
    private DataLoader dataLoader;
    private boolean isLoggedIn;

    /**
     * This method is the main driver method for the program.
     * @param args is the String array to take in values.
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        DataLoader dataLoader = new DataLoader();
        boolean isDone = false;

        UserInterface.printGreet();

        while(!isDone) {

            printWelcomeMenu();
            System.out.print("Select an option to proceed: ");
            int input = userInput.nextInt();

            switch (input) {
                case 1:
                    // TODO: Implement Login method.
                    System.out.println("Network is currently unavailable.");
                    printDashes();
                    break;

                case 2:
                    // TODO: Implement Register new user method.
                    System.out.println("Please wait for a Librarian.");
                    printDashes();
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

    /**
     * This method prints a decorative line to the screen.
     */
    private static void printDashes() {
        System.out.println("-------------------------------");
    }

    /**
     * This method prints out the "Welcome" menu options to the screen.
     */
    private static void printWelcomeMenu() {
        System.out.println("1) Login");
        System.out.println("2) Register New User");
        System.out.println("3) Exit Program");
    }

    /**
     * This method prints the Administrator User menu to the screen.
     */
    private void printAdminMenu() {
        System.out.println("1) Add New Item");
        System.out.println("2) Apply Fees");
        System.out.println("3) Log Out");
    }

    /**
     * This method prints the Standard User menu to the screen.
     */
    private void printStandardMenu() {
        System.out.println("1) View Media List");
        System.out.println("2) View Media Hold Status");
        System.out.println("3) View Account Balance");
        System.out.println("4) Search for Media");
        System.out.println("5) Check In Media");
        System.out.println("6) Register Child");
        System.out.println("7) Log Out");
    }
}
