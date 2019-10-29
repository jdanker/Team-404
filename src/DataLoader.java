
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader {
	private static final String PEOPLE_FILE_NAME = "people.json";
	
	public static ArrayList<book> loadBooks() {
		ArrayList<book> books = new ArrayList<book>();
		
		try {
			FileReader reader = new FileReader("JSON/books.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray peopleJSON = (JSONArray)jsonData.get("books");
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				long id = (long)personJSON.get("id");
				String title = (String)personJSON.get("title");
				long year = (long)personJSON.get("year");
				String genre = (String)personJSON.get("genre");
				String ISBN = (String)personJSON.get("ISBN");
				String publisher = (String)personJSON.get("publisher");
				String author = (String)personJSON.get("author");
				long numCopies = (long)personJSON.get("numCopies");
				boolean newArrival = (boolean)personJSON.get("newArrival");
				
				books.add(new book(id, title, year, genre, ISBN, publisher, author, numCopies, newArrival));
			}
			
			return books;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
