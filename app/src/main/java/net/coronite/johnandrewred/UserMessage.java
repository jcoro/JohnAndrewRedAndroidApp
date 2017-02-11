package net.coronite.johnandrewred;



public class UserMessage {
    private String text;
    private String name;
    private String photoUrl;
    private long dateLong;

    public UserMessage() {
    }

    public UserMessage(String text, String name, String photoUrl, long dateLong) {
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
        this.dateLong = dateLong;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public long getDateLong() { return dateLong; }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
