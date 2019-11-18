public class book extends Media {

    String ISBN;
    String publisher;
    String author;

    public book(long id, String title, long year, String genre, String ISBN, String publisher, String author, long numCopies, boolean newArrival, String reviews)
    {
        this.ID = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.author = author;
        this.numCopies = numCopies;
        this.newRelease = newArrival;
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\nTitle: " + title + "\nYear of Release: " + year + "\nGenre: " + genre + " \nISBN: " + ISBN
                + "\nPublisher: " + publisher + " \nAuthor: " + author + "\nNumber of Copies: " + numCopies + "\nNew Arrival: " + newRelease;
    }
}
