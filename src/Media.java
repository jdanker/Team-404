public abstract class Media {
    public long ID;
    public String title;
    public long year;
    public String genre;
    public String dueDate = "";
    public boolean newRelease;
    public long numCopies;
    public String reviews;


    public long getID() {
        return ID;
    }

    public String getDueDate()  {return this.dueDate;}

    public String getTitle() {
        return title;
    }

    public long getNumCopies() {
        return numCopies;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setDueDate(String dueDate)  {this.dueDate = dueDate;}

    public void setNumCopies(long numCopies) {
        this.numCopies = numCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
