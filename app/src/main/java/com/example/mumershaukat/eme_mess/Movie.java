package com.example.mumershaukat.eme_mess;


/**
        * Created by pc on 4/25/2017.
        */

public class Movie {
    private String title, year;

    public Movie() {
    }

    public Movie(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
