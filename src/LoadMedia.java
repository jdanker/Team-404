
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class LoadMedia {
	private static final String BOOK_FILE_NAME = "JSON/books.json";
	private static final String DVD_FILE_NAME = "JSON/dvds.json";
	private static final String MAGAZINE_FILE_NAME = "JSON/magazines.json";

	/**
	 * Method that takes in a JSON file full of books, and returns an arrayList of said books
	 */

	public static ArrayList<book> loadBooks() {
		ArrayList<book> books = new ArrayList<book>();
		
		try {
			FileReader reader = new FileReader(BOOK_FILE_NAME); //Read in json file
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader); //Parser splits it into necessary sections and creates an object for each
			JSONArray booksJSON = (JSONArray)jsonData.get("books"); //Go into the books section of file (all of it)
			
			for(int i=0; i < booksJSON.size(); i++) { //For every object created in this json, do this
				JSONObject bookJSON = (JSONObject)booksJSON.get(i); //Get the current object

				//Pulling all the variables from the object
				long id = (long)bookJSON.get("id");
				String title = (String)bookJSON.get("title");
				long year = (long)bookJSON.get("year");
				String genre = (String)bookJSON.get("genre");
				String ISBN = (String)bookJSON.get("ISBN");
				String publisher = (String)bookJSON.get("publisher");
				String author = (String)bookJSON.get("author");
				long numCopies = (long)bookJSON.get("numCopies");
				boolean newArrival = (boolean)bookJSON.get("newArrival");

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
	 * Same as above for books, except with different member variables
	 * @return
	 */
	public static ArrayList<DVD> loadDvds() {
		ArrayList<DVD> dvds = new ArrayList<>();

		try {
			FileReader reader = new FileReader(DVD_FILE_NAME);
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray dvdsJSON = (JSONArray)jsonData.get("dvds");

			for(int i=0; i < dvdsJSON.size(); i++) {
				JSONObject dvdJSON = (JSONObject)dvdsJSON.get(i);
				long id = (long)dvdJSON.get("id");
				String title = (String)dvdJSON.get("title");
				long year = (long)dvdJSON.get("year");
				String genre = (String)dvdJSON.get("genre");
				String actors = dvdJSON.get("actors").toString();
				String director = (String)dvdJSON.get("director");
				long numCopies = (long)dvdJSON.get("numCopies");
				boolean newArrival = (boolean)dvdJSON.get("newArrival");

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
	 * @return
	 */
	public static ArrayList<magazine> loadMagazines() {
		ArrayList<magazine> mags = new ArrayList<>();

		try {
			FileReader reader = new FileReader(MAGAZINE_FILE_NAME);
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray magazinesJSON = (JSONArray)jsonData.get("magazines");

			for(int i=0; i < magazinesJSON.size(); i++) {
				JSONObject magazineJSON = (JSONObject)magazinesJSON.get(i);
				long id = (long)magazineJSON.get("id");
				String title = (String)magazineJSON.get("title");
				long year = (long)magazineJSON.get("year");
				String genre = (String)magazineJSON.get("genre");
				long volume = (long)magazineJSON.get("volume");
				String publisher = (String)magazineJSON.get("publisher");
				long issue = (long)magazineJSON.get("issue");
				long numCopies = (long)magazineJSON.get("numCopies");
				boolean newArrival = (boolean)magazineJSON.get("newArrival");

				mags.add(new magazine(id, title, year, genre, publisher, volume, issue, numCopies, newArrival));
			}
			return mags;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Media> getMediaList()
	{
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
}
