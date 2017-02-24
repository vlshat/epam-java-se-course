package com.github.vlshat.epam.unit02.task04;

import com.github.vlshat.epam.unit02.task03.OfficeSupply;

import java.util.Comparator;

/**
 * Created by wladislaw on 24.02.17.
 */
public class PriceComparator implements Comparator<OfficeSupply> {
    @Override
    public int compare(OfficeSupply o1, OfficeSupply o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
