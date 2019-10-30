import java.util.ArrayList;

public class DataLoaderTester {

	public static void main(String[] args) {
		Books books = Books.getInstance();
		ArrayList<book> booklist = books.getBooks();

		DVDs dvds = DVDs.getInstance();
		ArrayList<DVD> dvdList = dvds.getDVDs();

		Magazines magazines = Magazines.getInstance();
		ArrayList<magazine> magazineList = magazines.getMagazines();

		ArrayList<Media> totalMaterialsList = new ArrayList<>();

		totalMaterialsList.addAll(booklist);
		totalMaterialsList.addAll(magazineList);
		totalMaterialsList.addAll(dvdList);

		for(int i = 0; i < totalMaterialsList.size(); i++)
		{
			System.out.println(totalMaterialsList.get(i).toString());
			System.out.println("\n");
		}
	}

}
