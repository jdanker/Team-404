public class DVD extends Media {
    String actors;
    String director;

    public DVD(long id, String title, long year, String genre, String actors, String director, long numCopies, boolean newArrival)
    {
        this.ID = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.actors = actors;
        this.director = director;
        this.numCopies = numCopies;
        this.newRelease = newArrival;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\nTitle: " + title + "\nYear of Release: " + year + "\nGenre: " + genre
                + "\nActors: " + actors + " \nDirector: " + director + "\nNumber of Copies: " + numCopies;
    }
}
