public class DVD extends Media {
    long id;
    String title;
    long year;
    String actors;
    String director;
    long numCopies;


    public DVD(long id, String title, long year,  String actors, String director, long numCopies)
    {
        this.id = id;
        this.title = title;
        this.year = year;
        this.actors = actors;
        this.director = director;
        this.numCopies = numCopies;

    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTitle: " + title + "\nYear of Release: " + year + "\nGenre: " + genre
                + "\nActors: " + actors + " \nDirector: " + director + "\nNumber of Copies: " + numCopies;
    }
}
