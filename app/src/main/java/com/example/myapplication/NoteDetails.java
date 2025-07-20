package com.example.myapplication;

public class NoteDetails {
    private String tittle;
    private String author;
    private String description;

    public NoteDetails() {

    }

    public NoteDetails(String tittle, String author, String description) {
        this.tittle = tittle;
        this.author = author;
        this.description = description;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
