package com.github.vlshat.epam.unit04.task04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wladislaw on 05.03.17.
 */
public class FilmCollection implements Serializable{

    private final String COLLECTION_ID = UUID.randomUUID().toString();
    private List<Film> films = new ArrayList<>();

    public void addFilm(Film film){
        if (films.contains(film))
            throw new IllegalArgumentException("Film already in this collection");
        films.add(film);
    }

    public String getFilmsInformation(){
        StringBuilder builder = new StringBuilder();

        for (Film film : films){
            builder.append(film.toString()).append("\n");
        }

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    public String getCOLLECTION_ID(){
        return COLLECTION_ID;
    }

    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(COLLECTION_ID + ".unit04result"));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public static FilmCollection loadCollectionFormFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName + ".unit04result"));
        FilmCollection filmCollection = (FilmCollection) objectInputStream.readObject();
        objectInputStream.close();
        return filmCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmCollection that = (FilmCollection) o;

        if (COLLECTION_ID != null ? !COLLECTION_ID.equals(that.COLLECTION_ID) : that.COLLECTION_ID != null)
            return false;
        return films != null ? films.equals(that.films) : that.films == null;
    }

    @Override
    public int hashCode() {
        int result = COLLECTION_ID != null ? COLLECTION_ID.hashCode() : 0;
        result = 31 * result + (films != null ? films.hashCode() : 0);
        return result;
    }
}
