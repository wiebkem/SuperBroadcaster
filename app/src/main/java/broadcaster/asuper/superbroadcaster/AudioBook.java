package broadcaster.asuper.superbroadcaster;

import android.media.Image;

public class AudioBook {
    private String title;
    private String user;
    private String location;
    private Image imageUrl;

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

    public Image getImageUrl() { return imageUrl; }

    public void setImageUrl(Image imageUrl) {
        this.imageUrl = imageUrl;
    }
}
