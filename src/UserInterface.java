public class UserInterface {

    public static void printGreet() {
        printDashes();
        System.out.println("    Welcome to Local Library");
        printDashes();
    }

    /**
     * This method prints a decorative line to the screen.
     */
    public static void printDashes() {
        System.out.println("-------------------------------");
    }

    /**
     * This method prints out the "Welcome" menu options to the screen.
     */
    public static void printWelcomeMenu() {
        System.out.println("1) Login");
        System.out.println("2) Register New User");
        System.out.println("3) Exit Program");
    }

    /**
     * This method prints the Administrator User menu to the screen.
     */
    public void printAdminMenu() {
        System.out.println("1) Add New Item");
        System.out.println("2) Apply Fees");
        System.out.println("3) Log Out");
    }

    /**
     * This method prints the Standard User menu to the screen.
     */
    public static void  printStandardMenu() {
        System.out.println("1) View Media List");
        System.out.println("2) View Media Hold Status");
        System.out.println("3) View Account Balance");
        System.out.println("4) Search for Media");
        System.out.println("5) Check In Media");
        System.out.println("6) Register Child");
        System.out.println("7) Log Out");
    }
}
