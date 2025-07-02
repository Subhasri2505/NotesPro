package com.example.myapplication;

import com.google.firebase.Timestamp;

public class Note {
    private String title;
    private String content;
    private Timestamp timestamp;

    // Required no-arg constructor for Firestore
    public Note() {}

    public Note(String title, String content, Timestamp timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
