package broadcaster.asuper.superbroadcaster;

public class AudioBookBase {
    private String title;
    private int image;

    public AudioBookBase(String title, int image) {
        this.title = title;
        this.image = image;
    }

    // Getter- and setter-functions
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() { return image; }

    public void setImage(int image) {
        this.image = image;
    }
}
