import java.util.ArrayList;

public class BookInterface {

	public static void main(String[] args) {
		Books books = Books.getInstance();
		ArrayList<book> booklist = books.getBooks();

		for(int i = 0; i < booklist.size(); i++)
		{
			System.out.println(booklist.get(i).toString());
			System.out.println("\n\n");
		}
	}

}
