package com.github.vlshat.epam.unit02.task02;

import java.math.BigDecimal;

/**
 * Created by wladislaw on 24.02.17.
 */
public class OfficeSupply {
    private String name;
    private BigDecimal price;

    public OfficeSupply(String name, BigDecimal price) {
        this.name = name;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
