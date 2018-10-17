package broadcaster.asuper.superbroadcaster;

public class AudioBook extends AudioBookBase {
    private String user;
    private String location;

    public AudioBook(String title, String user, String location, int image) {
        super(title, image);
        this.user = user;
        this.location = location;
    }

    // Getter- and setter-functions

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
