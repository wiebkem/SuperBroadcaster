package broadcaster.asuper.superbroadcaster;

public class AudioBooklist extends AudioBookBase {

    private String author;
    private String time;

    public AudioBooklist(String title, String author, String time, int image) {
        super(title, image);
        this.author = author;
        this.time = time;
    }

    // Getter- and setter-functions

    public void setAuthor(String author) { this.author = author; }
    public void getAuthor(String author) { this.author = author; }



    public String setTime() {
        return time;
    }
    public String getTimeTime() { return time; }
}
