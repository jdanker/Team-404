import java.util.ArrayList;

public class Magazines {
    private static Magazines magazines = null;
    public static ArrayList<magazine> magazineList = new ArrayList<magazine>();

    private Magazines()
    {
<<<<<<< HEAD
        magazineList = LoadMedia.loadMagazines();
=======
        magazineList = JSONReadWrite.loadMagazines();
>>>>>>> cbb9e4429a7375e839e2292c09296439136ad273
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
