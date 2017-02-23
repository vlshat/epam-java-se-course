package com.github.vlshat.epam.unit02.task03;

import java.math.BigDecimal;

/**
 * Created by wladislaw on 24.02.17.
 */
public class Paper extends OfficeSupply{

    private StringBuilder text = new StringBuilder();

    public Paper(String title, BigDecimal price) {
        super(title, price);
    }

    public void addText(String information){
        text.append(information);
    }

    public String showText(){
        return text.toString();
    }
}
