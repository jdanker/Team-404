/**
 * Large class that holds static methods that can edit the json inventory and user files. There is an add/remove
 * method for each type of media, and
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class JSONReadWrite {
	private static final String BOOK_FILE_NAME = "JSON/books.json";
	private static final String DVD_FILE_NAME = "JSON/dvds.json";
	private static final String MAGAZINE_FILE_NAME = "JSON/magazines.json";
	private static final String USER_FILE_NAME = "JSOn/users.json";

	/**
	 * Method that takes in a JSON file full of books, and returns an arrayList of said books
	 *
	 * @return ArrayList of books in inventory
	 */

	public static ArrayList<book> loadBooks() {
		ArrayList<book> books = new ArrayList<book>();

		try {
			FileReader reader = new FileReader(BOOK_FILE_NAME); //Read in json file
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader); //Parser splits it into necessary sections and creates an object for each
			JSONArray booksJSON = (JSONArray) jsonData.get("books"); //Go into the books section of file (all of it)

			for (int i = 0; i < booksJSON.size(); i++) { //For every object created in this json, do this
				JSONObject bookJSON = (JSONObject) booksJSON.get(i); //Get the current object

				//Pulling all the variables from the object
				long id = (long) bookJSON.get("id");
				String title = (String) bookJSON.get("title");
				long year = (long) bookJSON.get("year");
				String genre = (String) bookJSON.get("genre");
				String ISBN = (String) bookJSON.get("ISBN");
				String publisher = (String) bookJSON.get("publisher");
				String author = (String) bookJSON.get("author");
				long numCopies = (long) bookJSON.get("numCopies");
				boolean newArrival = (boolean) bookJSON.get("newArrival");

				//Add new book using previous variables
				books.add(new book(id, title, year, genre, ISBN, publisher, author, numCopies, newArrival));
			}
			//return arraylist
			return books;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Same as above for books, except with different member variables to match the DVD class
	 *
	 * @return ArrayList of DVD's in inventory
	 */
	public static ArrayList<DVD> loadDvds() {
		ArrayList<DVD> dvds = new ArrayList<>();

		try {
			FileReader reader = new FileReader(DVD_FILE_NAME);
			JSONObject jsonData = (JSONObject) new JSONParser().parse(reader);
			JSONArray dvdsJSON = (JSONArray) jsonData.get("dvds");

			for (int i = 0; i < dvdsJSON.size(); i++) {
				JSONObject dvdJSON = (JSONObject) dvdsJSON.get(i);
				long id = (long) dvdJSON.get("id");
				String title = (String) dvdJSON.get("title");
				long year = (long) dvdJSON.get("year");
				String genre = (String) dvdJSON.get("genre");
				String actors = dvdJSON.get("actors").toString();
				String director = (String) dvdJSON.get("director");
				long numCopies = (long) dvdJSON.get("numCopies");
				boolean newArrival = (boolean) dvdJSON.get("newArrival");

				dvds.add(new DVD(id, title, year, genre, actors, director, numCopies, newArrival));
			}

			return dvds;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Same as above for magazines instead of books and DVD's
	 *
	 * @return ArrayList of magazines in inventory
	 */
	public static ArrayList<magazine> loadMagazines() {
		ArrayList<magazine> mags = new ArrayList<>();

		try {
			FileReader reader = new FileReader(MAGAZINE_FILE_NAME);
			JSONObject jsonData = (JSONObject) new JSONParser().parse(reader);
			JSONArray magazinesJSON = (JSONArray) jsonData.get("magazines");

			for (int i = 0; i < magazinesJSON.size(); i++) {
				JSONObject magazineJSON = (JSONObject) magazinesJSON.get(i);
				long id = (long) magazineJSON.get("id");
				String title = (String) magazineJSON.get("title");
				long year = (long) magazineJSON.get("year");
				String genre = (String) magazineJSON.get("genre");
				long volume = (long) magazineJSON.get("volume");
				String publisher = (String) magazineJSON.get("publisher");
				long issue = (long) magazineJSON.get("issue");
				long numCopies = (long) magazineJSON.get("numCopies");
				boolean newArrival = (boolean) magazineJSON.get("newArrival");

				mags.add(new magazine(id, title, year, genre, publisher, volume, issue, numCopies, newArrival));
			}
			return mags;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Combines all above methods into one call that adds the entire inventory to one ArrayList
	 *
	 * @return Arraylist of all inventory in JSON files
	 */
	public static ArrayList<Media> getMediaList() {
		//Creates an array of books from the book json file
		Books books = Books.getInstance();
		ArrayList<book> booklist = books.getBooks();

		//Creates array of DVDs from json file
		DVDs dvds = DVDs.getInstance();
		ArrayList<DVD> dvdList = dvds.getDVDs();

		//Creates array of magazines from json file
		Magazines magazines = Magazines.getInstance();
		ArrayList<magazine> magazineList = magazines.getMagazines();

		//New arraylist to contain all the media types, AKA the whole library system
		ArrayList<Media> totalMaterialsList = new ArrayList<>();

		//Adds all media into materials list
		totalMaterialsList.addAll(booklist);
		totalMaterialsList.addAll(magazineList);
		totalMaterialsList.addAll(dvdList);

		return totalMaterialsList;
	}

	/**
	 * Takes in user file, and returns the arrayList of all users in file.
	 *
	 * @return Arraylist of all Users in JSON files
	 */
	public static ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<User>();

		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader);
			JSONArray usersJSON = (JSONArray) jsonData.get("users");
			for (int i = 0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject) usersJSON.get(i);

				long id = (long) userJSON.get("id");
				String firstName = (String) userJSON.get("firstName");
				String lastName = (String) userJSON.get("lastName");
				String address = (String) userJSON.get("address");
				String email = (String) userJSON.get("email");
				String phone = (String) userJSON.get("phone");
				long accountId = (long) userJSON.get("accountId");
				String type = (String) userJSON.get("type");
				double fines = (double) userJSON.get("fines");

				users.add(new User(id, firstName, lastName, address, email, phone, accountId, type, 0.0, new ArrayList<Media>()));
			}

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Adds a given book to the inventory
	 *
	 * @param book to be added to inventory JSON
	 */
	public static void addBook(book book) {
		try {
			FileReader reader = new FileReader(BOOK_FILE_NAME); //Read in json file
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader); //Parser splits it into necessary sections and creates an object for each
			JSONArray booksJSON = (JSONArray) jsonData.get("books"); //Creates an array with all the books inside of it

			JSONObject newBookDetails = new JSONObject(); //Used to store the member variables of the new book

			newBookDetails.put("id", book.ID); //Pulling all the member variables from given new book
			newBookDetails.put("title", book.title);
			newBookDetails.put("year", book.year);
			newBookDetails.put("genre", book.genre);
			newBookDetails.put("ISBN", book.ISBN);
			newBookDetails.put("publisher", book.publisher);
			newBookDetails.put("author", book.author);
			newBookDetails.put("numCopies", book.numCopies);
			newBookDetails.put("newArrival", book.newRelease);

			booksJSON.add(newBookDetails); //Adds new book to the array

			jsonData.put("books", booksJSON); //Addst he array to the JSON object for proper formatting

			try (FileWriter file = new FileWriter(BOOK_FILE_NAME)) {
				file.write(jsonData.toJSONString()); //Writes JSON object to string and adds it to file
				file.flush(); //Flush the writer before ending method
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds given DVD to inventory JSON file
	 *
	 * @param dvd to be added to inventory
	 *            <p>
	 *            See addBook for breakdown of what is happening in method
	 */
	public static void addDVD(DVD dvd) {
		try {
			FileReader reader = new FileReader(DVD_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader);
			JSONArray dvdsJson = (JSONArray) jsonData.get("dvds");

			JSONObject newDVDdetails = new JSONObject();

			newDVDdetails.put("id", dvd.ID);
			newDVDdetails.put("title", dvd.title);
			newDVDdetails.put("year", dvd.year);
			newDVDdetails.put("genre", dvd.genre);
			newDVDdetails.put("actors", dvd.actors);
			newDVDdetails.put("director", dvd.director);
			newDVDdetails.put("numCopies", dvd.numCopies);
			newDVDdetails.put("newArrival", dvd.newRelease);

			dvdsJson.add(newDVDdetails);
			jsonData.put("dvds", dvdsJson);


			try (FileWriter file = new FileWriter(DVD_FILE_NAME)) {
				file.write(jsonData.toJSONString());
				file.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Adds given Magazine to inventory JSON file
	 *
	 * @param magazine to be added to inventory
	 *
	 * See addBook for breakdown of what is happening in method
	 */
	public static void addMagazine(magazine magazine) {
		try {
			FileReader reader = new FileReader(MAGAZINE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader);
			JSONArray magazinesJson = (JSONArray) jsonData.get("magazines");

			JSONObject newMagDetails = new JSONObject();

			newMagDetails.put("id", magazine.ID);
			newMagDetails.put("title", magazine.title);
			newMagDetails.put("year", magazine.year);
			newMagDetails.put("genre", magazine.genre);
			newMagDetails.put("publisher", magazine.publisher);
			newMagDetails.put("volume", magazine.volume);
			newMagDetails.put("issue", magazine.issue);
			newMagDetails.put("numCopies", magazine.numCopies);
			newMagDetails.put("newArrival", magazine.newRelease);

			magazinesJson.add(newMagDetails);
			jsonData.put("magazines", magazinesJson);


			try (FileWriter file = new FileWriter(MAGAZINE_FILE_NAME)) {
				file.write(jsonData.toJSONString());
				file.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * Adds given user to JSON file
     *
     * @param user to be added to users list
     *
     * See addBook for breakdown of what is happening in method
     */
	public static void addUser(User user) {
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader);
			JSONArray usersJson = (JSONArray) jsonData.get("users");

			JSONObject newUserDetails = new JSONObject();

			newUserDetails.put("id", user.ID);
			newUserDetails.put("firstName", user.firstName);
			newUserDetails.put("lastName", user.lastName);
			newUserDetails.put("address", user.address);
			newUserDetails.put("email", user.email);
			newUserDetails.put("phone", user.phoneNumber);
			newUserDetails.put("accountId", user.accountID);
			newUserDetails.put("type", user.accountType);
			newUserDetails.put("fines", user.fines);

			usersJson.add(newUserDetails);
			jsonData.put("users", usersJson);


			try (FileWriter file = new FileWriter(DVD_FILE_NAME)) {
				file.write(jsonData.toJSONString());
				file.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove any books with matching titles
	 * @param title - Title of book(s) you would like to remove
	 */

	public static void deleteBook(String title) {
		try {
			FileReader reader = new FileReader(BOOK_FILE_NAME); //Read in json file
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader); //Parser splits it into necessary sections and creates an object for each
			JSONArray booksJSON = (JSONArray) jsonData.get("books"); //Creates an array with all the books inside of it

			for(int i = 0; i < booksJSON.size(); i++) //Walk through array
			{
				JSONObject currentBook = (JSONObject)booksJSON.get(i); //Create an object for each section of json file
				String currentTitle = (String)currentBook.get("title"); //Get the title of current book
				if(currentTitle.equalsIgnoreCase(title)) //Check vs supplied title
				{
					booksJSON.remove(i); //If title matches, remove it
				}
			}

			jsonData.clear(); //Clear out old jsonData
			jsonData.put("books", booksJSON); //Add new data into file

			try (FileWriter file = new FileWriter(BOOK_FILE_NAME)) { //Write it to new file
				file.write(jsonData.toJSONString());
				file.flush();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Any book with title: " + title + " has been removed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove any dvd's with matching titles
	 * @param title - Title of DVD you would like to remove
	 *
	 * See deleteBook method for details on how it functions
	 */
	public static void deleteDVD(String title) {
		try {
			FileReader reader = new FileReader(DVD_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader);
			JSONArray dvdJSON = (JSONArray) jsonData.get("dvds");

			for(int i = 0; i < dvdJSON.size(); i++)
			{
				JSONObject currentDVD = (JSONObject)dvdJSON.get(i);
				String currentTitle = (String)currentDVD.get("title");
				if(currentTitle.equalsIgnoreCase(title))
				{
					dvdJSON.remove(i);
				}
			}
			jsonData.clear();
			jsonData.put("dvds", dvdJSON);

			try (FileWriter file = new FileWriter(DVD_FILE_NAME)) {
				file.write(jsonData.toJSONString());
				file.flush();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Any DVD with title: " + title + " has been removed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove any magazines with matching titles
	 * @param title - Title of Magazine you would like to remove
	 *
	 * See deleteBook method for details on how it functions
	 */
	public static void deleteMagazine(String title) {
		try {
			FileReader reader = new FileReader(MAGAZINE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader);
			JSONArray magazineJSON = (JSONArray) jsonData.get("magazines");

			for(int i = 0; i < magazineJSON.size(); i++)
			{
				JSONObject currentMagazine = (JSONObject)magazineJSON.get(i);
				String currentTitle = (String)currentMagazine.get("title");
				if(currentTitle.equalsIgnoreCase(title))
				{
					magazineJSON.remove(i);
				}
			}
			jsonData.clear();
			jsonData.put("magazines", magazineJSON);

			try (FileWriter file = new FileWriter(MAGAZINE_FILE_NAME)) {
				file.write(jsonData.toJSONString());
				file.flush();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Any magazine with title: " + title + " has been removed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * Remove any magazines with matching titles
     * @param firstName - First name of user you would like to remove
     * @param lastName - Last name of user you would like to remove
     *
     * See deleteBook method for details on how it functions
     */
	public static void deleteUser(String firstName, String lastName) {
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject) parser.parse(reader);
			JSONArray usersArray = (JSONArray) jsonData.get("users");

			for(int i = 0; i < usersArray.size(); i++)
			{
				JSONObject currentuser = (JSONObject)usersArray.get(i);
				String currentFirstName = (String)currentuser.get("firstName");
				String currentLastName = (String)currentuser.get("lastName");
				if(currentFirstName.equalsIgnoreCase(firstName) && currentLastName.equalsIgnoreCase(lastName))
				{
					usersArray.remove(i);
				}
			}
			jsonData.clear();
			jsonData.put("users", usersArray);

			try (FileWriter file = new FileWriter(DVD_FILE_NAME)) {
				file.write(jsonData.toJSONString());
				file.flush();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Any user with name: " + firstName + " " + lastName + " has been removed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
