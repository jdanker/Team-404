public class magazine extends Media {
    long id;
    String title;
    long issue;
    String publisher;
    long volume;


    public magazine(long id, String title, long issue, String publisher, long volume)
    {
        this.id = id;
        this.title = title;
        this.issue = issue;
        this.publisher = publisher;
        this.volume = volume;

    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTitle: " + title + "\nIssue number: " + issue + "\nPublisher: " + publisher + "\nVolume Number: " + volume;
    }

}
