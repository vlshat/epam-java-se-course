package com.github.vlshat.epam.unit02.task03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladislaw on 24.02.17.
 */
public class OfficeSupplySetFactory {
    public List<OfficeSupply> getBeginnersSet(){

        List<OfficeSupply> set = new ArrayList<>();
        set.add(new Pen("Pilot", new BigDecimal(10)));
        set.add(new Folder("Folder", new BigDecimal(5)));
        set.add(new Paper("paper", new BigDecimal(0.5)));

        return set;
    }
}
