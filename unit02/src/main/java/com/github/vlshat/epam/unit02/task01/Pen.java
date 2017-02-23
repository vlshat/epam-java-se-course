package com.github.vlshat.epam.unit02.task01;

import java.math.BigDecimal;

/**
 * Created by wladislaw on 21.02.17.
 */
public class Pen {

    private String model;
    private PenType type;
    private int inkColour;
    private BigDecimal price;

    public Pen(String model, PenType type, int inkColour, BigDecimal price) {
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
        result = result * 31 + inkColour;
        result = result * 31 + price.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pen {\n")
                .append("Model: " + model + "\n")
                .append("Type: " + type + "\n")
                .append("Colour: " + inkColour + "\n")
                .append("Price: " + price)
                .append("}");
        return stringBuilder.toString();
    }
}
