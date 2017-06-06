package shop.bin.model.http.response;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/12/2017.
 */

public class NotificationItem {

    private int id;
    private String message;
    private String date;
    private int logoUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(int logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}


