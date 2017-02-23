package com.github.vlshat.epam.unit02.task03;

import java.math.BigDecimal;

/**
 * Created by wladislaw on 24.02.17.
 */
public class Pen extends OfficeSupply {
    public Pen(String title, BigDecimal price) {
        super(title, price);
    }

    public void write(Paper paper, String text){
        paper.addText(text);
    }
}
