package com.github.vlshat.epam.unit04.task04;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 05.03.17.
 */
public class FilmCollectionTest {
    @Test
    public void addFilm() throws Exception {

    }

    @Test
    public void getFilmsInformation() throws Exception {

    }

    @Test
    public void testSaveAndLoadMethods() throws Exception {
        FilmCollection filmCollection = new FilmCollection();
        filmCollection.save();
        assertEquals(filmCollection, FilmCollection.loadCollectionFormFile(filmCollection.getCOLLECTION_ID()));
    }

}