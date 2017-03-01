package com.github.vlshat.epam.unit02.task05.markcomparators;

import java.util.Comparator;

/**
 * Created by wladislaw on 02.03.17.
 */
public class DoubleMarkComparator implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        return Double.compare(o1, o2);
    }
}
