import java.util.ArrayList;

public class DVDs {

    private static DVDs dvds = null;
    public static ArrayList<DVD> dvdsList = new ArrayList<DVD>();

    private DVDs()
    {
        dvdsList = JSONReadWrite.loadDvds();
    }

    public static DVDs getInstance()
    {
        if(dvds == null)
        {
            dvds = new DVDs();
        }
        return dvds;
    }

    public ArrayList<DVD> getDVDs()
    {
        return dvdsList;
    }

    /**
     * prints the array list of the dvds
     */
    public static void printDVDs()    {
        for (int i = 0; i < dvdsList.size(); ++i)   {
            System.out.println(dvdsList.get(i).toString());
        }
    }

    /**
     * Method to find the index of a DVD in the list of available dvds
     * @param input
     * @return int val for index of DVD
     */
    public static int searchDVDs(String input)    {
        int retVal = 0;
        for (int i = 0; i < dvdsList.size(); ++i)   {
            if (dvdsList.get(i).title.equalsIgnoreCase(input))  {
                retVal = i;
            } else  {
                System.out.println("DVD not found");
            }
        }
        return retVal;
    }
}
