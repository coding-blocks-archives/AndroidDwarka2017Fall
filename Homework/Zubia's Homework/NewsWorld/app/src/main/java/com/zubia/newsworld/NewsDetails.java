package com.zubia.newsworld;

/**
 * Created by shahabkhan on 1/27/18.
 */

public class NewsDetails {
    private Integer ID;
    private String TITLE;
    private String URL;
    private String PUBLISHER;
    private String CATEGORY;
    private String HOSTNAME;
    private long TIMESTAMP;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setPUBLISHER(String PUBLISHER) {
        this.PUBLISHER = PUBLISHER;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public void setHOSTNAME(String HOSTNAME) {
        this.HOSTNAME = HOSTNAME;
    }

    public void setTIMESTAMP(long TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public Integer getID() {
        return ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getURL() {
        return URL;
    }

    public String getPUBLISHER() {
        return PUBLISHER;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public String getHOSTNAME() {
        return HOSTNAME;
    }


}
