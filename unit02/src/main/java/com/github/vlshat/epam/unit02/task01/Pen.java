package com.github.vlshat.epam.unit02.task01;

import java.math.BigDecimal;

/**
 * Created by wladislaw on 21.02.17.
 */
class Pen {

    private String model;
    private PenType type;
    private Colour inkColour;
    private BigDecimal price;

    public Pen(String model, PenType type, Colour inkColour, BigDecimal price) {
        this.model = model;
        this.type = type;
        this.inkColour = inkColour;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    }

    @Override
    public boolean equals(Object object) {

        if (object == null)
            return false;

        if (getClass() != object.getClass())
            return false;

        if (this == object)
            return true;

        Pen pen = (Pen) object;

        if (model.equals(pen.model) &&
                type == pen.type &&
                inkColour == pen.inkColour &&
                price.equals(pen.price)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = result * 31 + type.hashCode();
        result = result * 31 + inkColour.hashCode();
        result = result * 31 + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String result = String.format("Model: %s, Type: %s, Colour: %s, Price: %s RUR", model,
                type,
                inkColour,
                price);

        return result;
    }
}
