package shop.bin.model.http.response;

/**
 * Created by nguyenthanhdong0109@gmail.com on 6/5/17.
 */

public class Shop {

    private String name;
    private String description;
    private int thumbnail;

    public Shop(String name, String description, int thumbnail) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
