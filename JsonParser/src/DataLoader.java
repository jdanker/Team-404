
import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader {
	private static final String PEOPLE_FILE_NAME = "people.json";
	
	public static ArrayList<Person> loadPeople() {
		ArrayList<Person> people = new ArrayList<Person>();
		
		try {
			FileReader reader = new FileReader("src/people.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray peopleJSON = (JSONArray)jsonData.get("people");
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String firstName = (String)personJSON.get("firstName");
				String lastName = (String)personJSON.get("lastName");
				String phoneNumber = (String)personJSON.get("phoneNumber");
				
				people.add(new Person(firstName, lastName, phoneNumber));
			}
			
			return people;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
