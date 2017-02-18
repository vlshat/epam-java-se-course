package com.github.vlshat.unit01;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 05.02.17.
 */
public class IntArrayListTest {
    @Test
    public void binarySerachRec() throws Exception {
        int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1};
        Arrays.sort(ints);
        IntArrayList list = new IntArrayList(ints);
        System.out.println(Arrays.toString(ints));
        assertEquals(0, list.binarySearchRec(Integer.MIN_VALUE + 1, 0, ints.length));
        assertEquals(-1, list.binarySearchRec(Integer.MIN_VALUE, 0, ints.length));
        assertEquals(13, list.binarySearchRec(Integer.MAX_VALUE - 1, 0, ints.length));
        assertEquals(7, list.binarySearchRec(12, 0, ints.length));
        assertEquals(6, list.binarySearchRec(11, 0, ints.length));
    }

    @Test
    public void binarySearch() throws Exception {
        int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1};
        Arrays.sort(ints);
        System.out.println(ints[11]);
        IntArrayList list = new IntArrayList(ints);
        System.out.println(Arrays.toString(ints));
        assertEquals(0, list.binarySearch(Integer.MIN_VALUE + 1));
        assertEquals(-1, list.binarySearch(Integer.MIN_VALUE));
        assertEquals(13, list.binarySearch(Integer.MAX_VALUE - 1));
        assertEquals(7, list.binarySearch(12));
        assertEquals(5, list.binarySearch(11));

    }

    @Test
    public void sort() throws Exception {
        final int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        final int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        final IntArrayList list = new IntArrayList(ints);

        list.sort();

        for (int i = 0; i < expected.length; i++) {
            assertEquals("i = " + i, expected[i], list.get(i));
        }
    }

}