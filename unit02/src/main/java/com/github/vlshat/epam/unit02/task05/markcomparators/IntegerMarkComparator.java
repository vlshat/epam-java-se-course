package com.github.vlshat.epam.unit02.task05.markcomparators;

import java.util.Comparator;

/**
 * Created by wladislaw on 02.03.17.
 */
public class IntegerMarkComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}
