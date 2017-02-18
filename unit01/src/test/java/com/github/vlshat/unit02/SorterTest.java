package com.github.vlshat.unit02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 14.02.17.
 */
public class SorterTest {

    Sorter sorter;

    String[] zooSorted = {
            "hh",
            "elephant",
            "dog",
            "cat",
            "bird",
            "apple"
    };


    @Before
    public void init(){
        sorter = new Sorter();
    }

    @Test
    public void sortDesc() throws Exception {
        String[] zoo = {
                "hh",
                "apple",
                "bird",
                "cat",
                "dog",
                "elephant"
        };

        String[] result = sorter.sortDesc(zoo);

        assertArrayEquals(zoo, result);
    }

}