import java.util.ArrayList;

public class DVDs {

    private static DVDs dvds = null;
    public static ArrayList<DVD> dvdsList = new ArrayList<DVD>();

    private DVDs()
    {
<<<<<<< HEAD
        dvdsList = LoadMedia.loadDvds();
=======
        dvdsList = JSONReadWrite.loadDvds();
>>>>>>> cbb9e4429a7375e839e2292c09296439136ad273
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
