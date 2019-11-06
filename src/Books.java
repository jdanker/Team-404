import java.util.ArrayList;

public class Books {
	private static Books books = null;
	public static ArrayList<book> bookList = new ArrayList<book>();
	
	private Books() {
<<<<<<< HEAD
		bookList = LoadMedia.loadBooks();
=======
		bookList = JSONReadWrite.loadBooks();
>>>>>>> cbb9e4429a7375e839e2292c09296439136ad273
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
