package com.github.vlshat.epam.unit02.task02;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 24.02.17.
 */
public class SupplyAnalyzerTest {
    @Test
    public void getSum() throws Exception {
        List<OfficeSupply> list = new ArrayList<>();
        list.add(new OfficeSupply("Pen", new BigDecimal(100)));
        list.add(new OfficeSupply("Paperclip", new BigDecimal(0.02)));
        Person person = new Person("John" , "Doe", list);

        assertTrue(new SupplyAnalyzer().getSum(person) == 100.02);

    }

}