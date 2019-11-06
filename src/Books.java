import java.util.ArrayList;

public class Books {
	private static Books books = null;
	public static ArrayList<book> bookList = new ArrayList<book>();
	
	private Books() {
		bookList = JSONReadWrite.loadBooks();
	}
	
	public static Books getInstance() {
		if(books == null) {
			books = new Books();
		}
		
		return books;
	}
	
	public ArrayList<book> getBooks() {
		return bookList;
	}
}
