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

                    // Checks if user is in the data
                    selectedUser = login(un, pw);
                    isLoggedIn = selectedUser != null;

                    if(selectedUser.getAccountType() == "P") {
                        if (selectedUser.getFines()>0) {
                            System.out.println("You have unpaid fines! No books can be checked out until you pay your fines!");
                            System.exit(0);
                        }
                    }
                    // Runs the appropriate menu according to account type or tell the user the login is invalid.
                    if (!isLoggedIn) {
                        System.out.println("The username or password entered is invalid.");
                    } else {
                        System.out.println("You are now logged in. Let's run something.");
                    }
                    UserInterface.printDashes();

                    String type = selectedUser.getAccountType();
                    runUserMenu(selectedUser, type);



                    break;

                case 2:

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
        return getUser(userName, password);
    }

    private static void runUserMenu(User selectedUser, String type) {
        switch (type) {
            case "L": //Admin user "L" for librarian
                // Run Admin Menu
                runAdminMenu(selectedUser);
                break;
            case "T": //Teacher user "T"
                runTeacherMenu(selectedUser);
            case "C": //ChildUser "C"
                runChildMenu(selectedUser);
                break;
            case "P": //StandardUser "P"
                // Run Standard user Menu sequence.
                runStandardMenu(selectedUser);
                break;
            default:
                System.exit(0);
        }
    }

    private static void runStandardMenu(User user)   {
        Scanner input = new Scanner(System.in);
            UserInterface.printStandardMenu();
             String userInput = input.nextLine();
             int parsedInput = Integer.parseInt(userInput);
            int index;
            Media media;
            String title, type;

            switch (parsedInput)  {
                case 1:
                    System.out.println("Enter the number of the type of media you would like to see:");
                    System.out.println("1. Books");
                    System.out.println("2. Magazines");
                    System.out.println("3. DVDs");

                    int mediaType = input.nextInt();
                    switch (mediaType){
                        case 1:
                            Books.printBooks();
                            break;

                        case 2:
                            Magazines.printMagazines();
                            break;
                        case 3:
                            DVDs.printDVDs();
                            break;
                        default:
                            System.out.println("Invalid input. Enter a number between 1-3");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Holds: ");
                    break;
                case 3:
                    System.out.println("Account Balance: " + user.getFines());
                    break;
                case 4:
                    System.out.println("Enter the type of the media to be checked out:");
                    type = input.nextLine();
                    switch(type){
                        case "Book":
                            System.out.println("Enter the title of the media to be checked out: ");
                            title = input.nextLine();
                            index = Books.searchBooks(title);
                            media = Books.bookList.get(index);
                            user.checkoutMedia(media);
                            break;
                        case "DVD":
                            System.out.println("Enter the title of the media to be checked out: ");
                            title = input.nextLine();
                            index = DVDs.searchDVDs(title);
                            media = DVDs.dvdsList.get(index);
                            user.checkoutMedia(media);
                            break;
                        case "Magazine":
                            System.out.println("Enter the title of the media to be checked out: ");
                            title = input.nextLine();
                            index = Magazines.searchMagazines(title);
                            media = Magazines.magazineList.get(index);
                            user.checkoutMedia(media);
                            break;
                        default:
                            System.out.println("Please enter a valid type of media");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Enter the name of the media to be checked in: ");
                    break;
                case 6:
                    System.out.println("Register Child ");
                    break;
                case 7:
                    System.out.println("Logging out...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input. Please select a valid value");
                    break;
            }
        }


    private static void runChildMenu(User user)   {
        Scanner input = new Scanner(System.in);
        boolean loggedOut = false;
        String inString;

        while (!loggedOut)  {
            UserInterface.printChildMenu();
            int userInput = input.nextInt();

            switch (userInput)  {
                case 1:
                    System.out.println("Enter the number of the type of media you would like to see:");
                    System.out.println("1. Books");
                    System.out.println("2. Magazines");
                    System.out.println("3. DVDs");
                    System.out.println("4. Exit to menu");

                    userInput = input.nextInt();
                    switch (userInput)  {
                        case 1:
                            Books.printBooks();
                            break;
                        case 2:
                            Magazines.printMagazines();
                            break;
                        case 3:
                            DVDs.printDVDs();
                            break;
                        case 4:
                            return;
                        default:
                            System.out.println("Invalid input. Enter a number between 1-3");
                    }
                    break;
                case 2:
                    System.out.println("Holds: ");
                    break;
                case 3:
                    System.out.println("Enter the media to be checked in");
                    break;
                case 4:
                    System.out.println("Logging out...");
                    loggedOut = true;
                    return;
                default:
                    System.out.println("Invalid Input. Please select a valid value");
            }
        }
    }

    private static void runTeacherMenu(User user)    {
        Scanner input = new Scanner(System.in);
        boolean loggedOut = false;
        String inString;

        while (!loggedOut)  {
            UserInterface.printTeacherMenu();
            String userInput = input.nextLine();
            int parsedInput = Integer.parseInt(userInput);
            int index;
            Media media;
            String title, type;

            switch(parsedInput)   {
                case 1:
                    System.out.println("Enter the number of the type of media you would like to see:");
                    System.out.println("1. Books");
                    System.out.println("2. Magazines");
                    System.out.println("3. DVDs");
                    System.out.println("4. Exit to menu");

                    userInput = input.nextLine();
                    parsedInput = Integer.parseInt(userInput);
                    switch (parsedInput)  {
                        case 1:
                            Books.printBooks();
                            break;
                        case 2:
                            Magazines.printMagazines();
                            break;
                        case 3:
                            DVDs.printDVDs();
                            break;
                        case 4:
                            return;
                        default:
                            System.out.println("Invalid input. Enter a number between 1-3");
                    }
                    break;
                case 2:
                    System.out.println("Holds: ");
                    break;
                case 3:
                    System.out.println("Account Balance:" );
                    break;
                case 4:
                    System.out.println("Enter the type of the media to be checked in:");
                    type = input.nextLine();
                    System.out.println("Enter the title of the media to be checked out: ");
                    title = input.nextLine();
                    switch(type)    {
                        case "Book":
                            index = Books.searchBooks(title);
                            media = Books.bookList.get(index);
                            user.checkoutMedia(media);
                            break;
                        case "DVD":
                            index = DVDs.searchDVDs(title);
                            media = DVDs.dvdsList.get(index);
                            user.checkoutMedia(media);break;
                        case "Magazine":
                            index = Magazines.searchMagazines(title);
                            media = Magazines.magazineList.get(index);
                            user.checkoutMedia(media);
                        default:
                            System.out.println("Please enter a valid type of media");
                    }

                    break;
                case 5:
                    System.out.println("Enter the name of the media to be checked in:");
                    break;
                case 6:
                    System.out.println("Logging out...");
                    loggedOut = true;
                    return;
                default:
                    System.out.println("Invalid Input. Please select a valid value");

            }
        }
    }

    private static void runAdminMenu(User user) {
        Scanner input = new Scanner(System.in);
        boolean loggedOut = false;

        while (!loggedOut) {
            UserInterface.printAdminMenu();
            String userInput = input.nextLine();
            int parsedInput = Integer.parseInt(userInput);

            switch (parsedInput) {
                case 1:
                    System.out.println("Please input the type of media. \n1. Book \n2. DVD \n3.Magazine");
                    int mediaInput = Integer.parseInt(input.nextLine());

                    System.out.println("Please specify the ID of the new media:");
                    long id = Long.parseLong(input.nextLine());

                    System.out.println("Please specify the title of the new media:");
                    String title = input.nextLine();

                    System.out.println("Please specify the year of the new media:");
                    long year = Long.parseLong(input.nextLine());

                    System.out.println("Please specify the genre of the new media:");
                    String genre = input.nextLine();

                    System.out.println("Please specify if the new media is a new release:");
                    boolean newRelease = Boolean.parseBoolean(input.nextLine());

                    System.out.println("Please specify how many copies of the new media is available:");
                    long amount = Long.parseLong(input.nextLine());

                    switch (mediaInput) {
                        case 1:

                            System.out.println("Please specify the ISBN of the new book:");
                            String ISBN = input.nextLine();

                            System.out.println("Please specify the publisher of the new book:");
                            String publisher = input.nextLine();

                            System.out.println("Please specify the author of the new book:");
                            String author = input.nextLine();

                            book newbook = new book(id, title, year, genre, ISBN, publisher, author, amount, newRelease);

                            AdminUser.AddBook(newbook);
                            break;

                        case 2:
                            System.out.println("Please specify the publisher of the new magazine:");
                            publisher = input.nextLine();

                            System.out.println("Please specify the volume of the new magazine:");
                            long volume = Long.parseLong(input.nextLine());

                            System.out.println("Please specify the issue of the new magazine:");
                            long issue = Long.parseLong(input.nextLine());



                            magazine newMag = new magazine(id, title, year, genre, publisher, volume, issue, amount, newRelease);
                            AdminUser.AddMagazine(newMag);
                            break;

                        case 3:
                            System.out.println("Please input the actors on one line, separated by commas");
                            String actors = input.nextLine();

                            System.out.println("Please input the director of the DVD");
                            String director = input.nextLine();

                            DVD newDvd = new DVD(id, title, year, genre, actors, director, amount, newRelease);
                            AdminUser.AddDVD(newDvd);
                            break;
                    }


                case 2:
                    // adds fines to a user's current fine balance
                    System.out.println("Enter the first name of the person you would like to apply fees to: ");
                    String fName = input.next();
                    System.out.println("Enter the last name of the person you would like to apply fees to: ");
                    String lName = input.nextLine();

                    User user1 = getUser(fName, lName);
                    System.out.println("Enter the amount of fees to apply: ");
                    double feeAdd = input.nextInt();
                    double curFee = user1.getFines() + feeAdd;
                    user1.setFines(curFee);
                    System.out.println("Fees have been added. " + user1.firstName + "'s" + " have been updated to "+user1.getFines());
                    break;

                case 3:
                    System.out.println(user.firstName + " is now logged out.");
                    loggedOut = true;
                    UserInterface.printDashes();
                    break;

                default:
                    System.out.println("Invalid Input. Please select a valid value: (1 - 3)");
                    break;
            }
        }
    }
//    helper method to search a user by name
    public static User getUser(String fName, String lName){
        ArrayList<User> users = JSONReadWrite.loadUsers();

        // Makes sure the user list is not empty.
        assert users != null;

        // Checks if the user name and password matches existing users.
        for (User user : users) {
            if (user.firstName.equals(fName) && user.lastName.equals(lName)) {
                return user;
            }
        }
        return null;
    }
}
