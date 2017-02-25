package com.github.vlshat.epam.unit02.task03;

import com.github.vlshat.epam.unit02.task04.PriceComparator;
import com.github.vlshat.epam.unit02.task04.PriceTitleComparator;
import com.github.vlshat.epam.unit02.task04.TitleComparator;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by wladislaw on 24.02.17.
 */
public class ComparatorTest {

    @Test
    public void testPriceComparator() throws Exception {

        List<OfficeSupply> list = OfficeSupplySetFactory.getBeginnersSet();
        list.sort(new PriceComparator());
        List<OfficeSupply> expected = new ArrayList<>();

        expected.add(new Paper("Paper", new BigDecimal(0.5)));
        expected.add(new Paper("Paper", new BigDecimal(1)));
        expected.add(new Folder("Folder", new BigDecimal(5)));
        expected.add(new Pen("A-Pilot", new BigDecimal(10)));

        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).getPrice().equals(expected.get(i).getPrice()));
        }

    }

    @Test
    public void testTitleComparator() throws Exception {

        List<OfficeSupply> list = OfficeSupplySetFactory.getBeginnersSet();
        list.sort(new TitleComparator());
        List<OfficeSupply> expected = new ArrayList<>();

        expected.add(new Pen("A-Pilot", new BigDecimal(10)));
        expected.add(new Folder("Folder", new BigDecimal(5)));
        expected.add(new Paper("Paper", new BigDecimal(0.5)));
        expected.add(new Paper("Paper", new BigDecimal(1)));


        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).getTitle().equals(expected.get(i).getTitle()));
        }

    }

    @Test
    public void testPriceTitleComparator() throws Exception {

        List<OfficeSupply> list = OfficeSupplySetFactory.getBeginnersSet();
        list.sort(new PriceTitleComparator());
        List<OfficeSupply> expected = new ArrayList<>();

        expected.add(new Pen("A-Pilot", new BigDecimal(10)));
        expected.add(new Folder("Folder", new BigDecimal(5)));
        expected.add(new Paper("Paper", new BigDecimal(0.5)));
        expected.add(new Paper("Paper", new BigDecimal(1)));


        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).getPrice().
                    equals(expected.get(i).getPrice()) &&
                    list.get(i).getTitle()
                            .equals(expected.get(i).getTitle()));
        }

    }
}
