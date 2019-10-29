import java.util.Scanner;
public class Driver {
    // Class Properties
    private DataLoader dataLoader = new DataLoader();
    private Boolean isLoggedIn = false;

    /**
     * This method is the main driver method for the program.
     * @param args is the String array to take in values.
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        DataLoader dataLoader = new DataLoader();
        Boolean isDone = false;

        printDashes();
        System.out.println("    Welcome to Local Library");
        printDashes();

        while(!isDone) {

            System.out.println("Select an option below to proceed: ");
            printWelcomeMenu();

            userInput.nextInt();

            System.out.println("You entered: " + userInput);
            isDone = true;

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
    private void printAdminMenu() {}

    /**
     * This method prints the Standard User menu to the screen.
     */
    private void printStandardMenu() {}
}
