import java.util.ArrayList;

public class Magazines {
    private static Magazines magazines = null;
    public static ArrayList<magazine> magazineList = new ArrayList<magazine>();

    private Magazines()
    {
        magazineList = JSONReadWrite.loadMagazines();
    }

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
}
