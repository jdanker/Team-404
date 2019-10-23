import java.util.ArrayList;

public class PersonInterface {

	public static void main(String[] args) {
		People people = People.getInstance();
		ArrayList<Person> friends = people.getPeople();
		
		for(Person person : friends) {
			System.out.println(person.getFirstName() + " " + person.getLastName() + ": " + person.getPhoneNumber());
		}
	}

}
