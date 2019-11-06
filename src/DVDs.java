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
}
