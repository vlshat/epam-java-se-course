package com.github.vlshat.epam.unit04.task04;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wladislaw on 05.03.17.
 */
public class Film implements Serializable{

    private String title;
    private List<Actor> cast = new ArrayList<>();
    private int year;
    private String genre;

    public Film(String title, int year, String genre) {

        if (title == null || genre == null)
            throw new IllegalArgumentException("Arguments can not be null");
        this.title = title;
        this.year = year;
        this.genre = genre;
    }


    public void addActor(Actor actor){
        if (cast.contains(actor))
            throw new IllegalArgumentException("Actor already in this film");

        cast.add(actor);
    }

    public String getTitle() {
        return title;
    }

    public String toString(){
        return String.format("%s, genre: %s, year: %d", title, genre, year);
    }
}
