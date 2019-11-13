import java.util.ArrayList;

public class Magazines {

    /**
     * attributes
     */
    private static Magazines magazines = null;
    public static ArrayList<magazine> magazineList = JSONReadWrite.loadMagazines();
    private Magazines()
    {
        magazineList = JSONReadWrite.loadMagazines();
    }

    /**
     * makes sure one instance of magazines is being used at a time
     * @return an instance of magazines
     */
    public static Magazines getInstance()
    {
        if(magazines == null)
        {
            magazines = new Magazines();
        }
        return magazines;
    }

    public ArrayList<magazine> getMagazines()
    {
        return magazineList;
    }

    /**
     * prints the array list of the magazines
     */
    public static void printMagazines()    {
        for (int i = 0; i < magazineList.size(); ++i)   {
            System.out.println(magazineList.get(i).toString());
        }
    }

    /**
     * Method to find the index of a Magazine in the list of available magazines
     * @param input
     * @return int val for index of Magazine
     */
    public static int searchMagazines(String input)    {
        int retVal = 0;
        for (int i = 0; i < magazineList.size(); ++i)   {
            if (magazineList.get(i).title.equalsIgnoreCase(input))  {
                retVal = i;
            } else  {
                System.out.println("Magazine not found");
            }
        }
        return retVal;
    }
}
