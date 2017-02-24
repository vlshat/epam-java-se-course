package com.github.vlshat.epam.unit02.task03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladislaw on 24.02.17.
 */
public class OfficeSupplySetFactory {

    public static List<OfficeSupply> getBeginnersSet(){

        List<OfficeSupply> set = new ArrayList<>();

        set.add(new Paper("Paper", new BigDecimal(1)));
        set.add(new Pen("A-Pilot", new BigDecimal(10)));
        set.add(new Folder("Folder", new BigDecimal(5)));
        set.add(new Paper("Paper", new BigDecimal(0.5)));


        return set;
    }
}
