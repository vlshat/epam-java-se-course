package com.github.vlshat.hw1;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 01.02.17.
 */
public class IntSetTest {
    @Test
    public void add() throws Exception {
        IntSet intSet = new IntSet();


        assertTrue(intSet.add(0));
        assertTrue(intSet.add(1));
        assertTrue(intSet.contains(1));
        assertTrue(intSet.add(Integer.MAX_VALUE));
        assertTrue(intSet.contains(Integer.MAX_VALUE));
        assertTrue(intSet.add((int) Math.pow(2, 30)));
        assertTrue(intSet.contains((int) Math.pow(2, 30)));
        assertTrue(intSet.add(-1));
        assertTrue(intSet.contains(-1));
        assertTrue(intSet.add(Integer.MIN_VALUE));
        assertTrue(intSet.contains(Integer.MIN_VALUE));
    }

    @Test
    public void remove() throws Exception {
        IntSet intSet = new IntSet();
        intSet.add(7);
        intSet.remove(7);
        assertTrue(intSet.equals(new IntSet()));

    }

    @Test
    public void contains() throws Exception {
        IntSet intSet = new IntSet();
        intSet.add(128);
        intSet.add(-128);
        assertTrue(intSet.contains(128));
        assertTrue(intSet.contains(-128));
    }

    @Test
    public void union() throws Exception {
        IntSet set1 = new IntSet();

        set1.add(64);
        set1.add(128);
        set1.add(1024);

        IntSet set2 = new IntSet();

        set2.add(63);
        set2.add(127);
        set2.add(1023);

        IntSet controlSet = new IntSet();

        controlSet.add(63);
        controlSet.add(64);
        controlSet.add(127);
        controlSet.add(128);
        controlSet.add(1023);
        controlSet.add(1024);

        IntSet result = set1.union(set2);

        assertTrue(result.equals(controlSet));
    }

    @Test
    public void intersection() throws Exception {
        IntSet set1 = new IntSet();
        set1.add(128);
        set1.add(256);
        set1.add(300);

        IntSet set2 = new IntSet();
        set2.add(128);
        set2.add(256);
        set2.add(1);

        IntSet control = new IntSet();
        control.add(128);
        control.add(256);

        IntSet result = set1.intersection(set2);

        assertTrue(result.equals(control));
    }

    @Test
    public void difference() throws Exception {
        IntSet set1 = new IntSet();
        set1.add(8);
        set1.add(64);
        set1.add(128);

        IntSet set2 = new IntSet();
        set2.add(128);
        set2.add(256);
        set2.add(3);

        IntSet control = new IntSet();
        control.add(8);
        control.add(64);
        control.add(128);
        control.remove(128);

        IntSet result = set1.difference(set2);

        assertTrue(result.equals(control));
    }

    @Test
    public void isSubsetOf() throws Exception {
        IntSet set1 = new IntSet();
        set1.add(128);
        set1.add(256);
        set1.add(512);
        set1.add(1024);

        IntSet set2 = new IntSet();
        set2.add(128);
        set2.add(256);

        IntSet set3 = new IntSet();
        set3.add(128);
        set3.add(12);

        assertTrue(set2.isSubsetOf(set1));
        assertFalse(set3.isSubsetOf(set1));
    }

}