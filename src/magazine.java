public class magazine extends Media {

    long issue;
    String publisher;
    long volume;


    public magazine(long id, String title, long year, String genre, String publisher, long volume, long issue, long numCopies, boolean newArrival, String reviews)
    {
        this.ID = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.issue = issue;
        this.publisher = publisher;
        this.volume = volume;
        this.numCopies = numCopies;
        this.newRelease = newArrival;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\nTitle: " + title + "\nYear: " + year + "\nGenre: " + genre + "\nPublisher: " + publisher +
                "\nVolume Number: " + volume + "\nIssue Number: " + issue + "\nNumber of Copies: " + numCopies + "\nNew Release: " + newRelease;
    }

}
