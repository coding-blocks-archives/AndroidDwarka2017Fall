package com.codingblocks.notes;

/**
 * Created by harshit on 06/01/18.
 */

public class Note {
    String title, description;
    Boolean isDone;

    public Note(String title, String description, Boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Note(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getDone() {
        return isDone;
    }
}
