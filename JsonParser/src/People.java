import java.util.ArrayList;

public class People {
	private static People people = null;
	private static ArrayList<Person> personList = new ArrayList<Person>();
	
	private People() {
		personList = DataLoader.loadPeople();
	}
	
	public static People getInstance() {
		if(people == null) {
			people = new People();
		}
		
		return people;
	}
	
	public ArrayList<Person> getPeople() {
		return personList;
	}
}
