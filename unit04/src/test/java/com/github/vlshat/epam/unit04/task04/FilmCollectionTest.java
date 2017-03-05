package com.github.vlshat.epam.unit04.task04;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 05.03.17.
 */
public class FilmCollectionTest {

    @Test(expected = IllegalArgumentException.class)
    public void ActorTest() throws Exception {
        Actor actor = new Actor("Ryan", "Gosling");
        Actor actor1 = new Actor(null, " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFilm() throws Exception {
        FilmCollection filmCollection = new FilmCollection();
        Film film = new Film("Apocalypse now", 1979, "Drama");
        filmCollection.addFilm(film);
        filmCollection.addFilm(film);
    }

    @Test
    public void getFilmsInformation() throws Exception {
        Film film = new Film("La La Land", 2017, "Musical");
        film.addActor(new Actor("Ryan", "Gosling"));
        film.addActor(new Actor("Emma", "Stone"));

        Film film1 = new Film("Apocalypse now", 1979, "Drama");
        film1.addActor(new Actor("Martin", "Sheen"));
        film1.addActor(new Actor("Marlon", "Brando"));

        FilmCollection filmCollection = new FilmCollection();
        filmCollection.addFilm(film);
        filmCollection.addFilm(film1);

        assertEquals(film + "\n" + film1, filmCollection.getFilmsInformation());

    }

    @Test
    public void testSaveAndLoadMethods() throws Exception {
        FilmCollection filmCollection = new FilmCollection();
        filmCollection.save();
        assertEquals(filmCollection, FilmCollection.loadCollectionFormFile(filmCollection.getCOLLECTION_ID()));
    }

}