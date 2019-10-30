import java.util.ArrayList;

public class DataLoaderTester {
	/**
	 * Sample main to show and test the dataLoader class and methods.
	 */
	public static void main(String[] args) {

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

		//Prints out materials list
		printArrayList(totalMaterialsList);
	}

	/**
	 * Simple method to print out an arraylist that already has a toString method
	 * @param printMe is the arraylist you would like printed
	 */
	public static void printArrayList(ArrayList printMe) {
		for (int i = 0; i < printMe.size(); i++) {
			System.out.println(printMe.get(i).toString());
			System.out.println("\n");
		}
	}
}
