public class book {
    long id;
    String title;
    long year;
    String genre;
    String ISBN;
    String publisher;
    String author;
    long numCopies;
    boolean newArrival;

    public book(long id, String title, long year, String genre, String ISBN, String publisher, String author, long numCopies, boolean newArrival)
    {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.author = author;
        this.numCopies = numCopies;
        this.newArrival = newArrival;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTitle: " + title + "\nYear of Release: " + year + "\nGenre: " + genre + " \nISBN: " + ISBN
                + "\nPublisher: " + publisher + " \nAuthor: " + author + "\nNumber of Copies: " + numCopies + "\nNew Arrival: " + newArrival;
    }
}
