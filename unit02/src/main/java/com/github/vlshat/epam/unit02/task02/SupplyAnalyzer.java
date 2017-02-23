package com.github.vlshat.epam.unit02.task02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wladislaw on 24.02.17.
 */

class SupplyAnalyzer {

    double getSum(Person person) {

        List<OfficeSupply> list = person.getOfficeSupplies();
        double price = 0;

        for (OfficeSupply supply : list){
            price += supply.getPrice().doubleValue();
        }

        return price;
    }

}
