package broadcaster.asuper.superbroadcaster;

public class AudioBook {
    private String title;
    private String user;
    private String location;
    private String imageUrl;

    public AudioBook(String title, String user, String location, String imageUrl) {
        this.title = title;
        this.user = user;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    // Getter- and setter-functions
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
