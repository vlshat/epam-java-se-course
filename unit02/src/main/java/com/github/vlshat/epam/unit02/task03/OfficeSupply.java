package com.github.vlshat.epam.unit02.task03;

import java.math.BigDecimal;

/**
 * Created by wladislaw on 24.02.17.
 */
public abstract class OfficeSupply{

    private String title;
    private BigDecimal price;

    public OfficeSupply(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
