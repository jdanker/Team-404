import java.util.ArrayList;

public class Books {

	/**
	 * attributes
	 */
	private static Books books = null;
	public static ArrayList<book> bookList = JSONReadWrite.loadBooks();
	private Books() {
		bookList = JSONReadWrite.loadBooks();
	}

	/**
	 * Makes sure one instanc eof books is being used at a time
	 * @return an insance of books
	 */
	public static Books getInstance() {
		if(books == null) {
			books = new Books();
		}
		return books;
	}

	public ArrayList<book> getBooks() {
		return bookList;
	}

    /**
     * prints the array list of the books
     */
	public static void printBooks()  {
	    for (int i = 0; i < bookList.size(); ++i)   {
	        System.out.println(bookList.get(i).toString());
        }
	}

    /**
     * Method to find the index of a books in the list of available books
     * @param input
     * @return int val for index of books
     */
	public static int searchBooks(String input)    {
	    int retVal = 0;
	    for (int i = 0; i < bookList.size(); ++i)   {
	        if (bookList.get(i).title.equalsIgnoreCase(input))  {
                retVal = i;
            } else  {
	            System.out.println("Book not found");
            }
        }
	    return retVal;
    }
}
