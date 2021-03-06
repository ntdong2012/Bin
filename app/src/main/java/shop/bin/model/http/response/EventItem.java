package shop.bin.model.http.response;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/13/17.
 */

public class EventItem {

    private int id;
    private String name;
    private String message;
    private String duration;

    public EventItem(String name) {
        this.name = name;
    }

    public EventItem(String name, String message, String duration) {
        this.name = name;
        this.message = message;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
