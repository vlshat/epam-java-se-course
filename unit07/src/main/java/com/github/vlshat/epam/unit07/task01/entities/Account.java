package com.github.vlshat.epam.unit07.task01.entities;

import java.math.BigDecimal;

/**
 * Created by vladislav on 20.03.17.
 */
public class Account {

    private long id;
    private String ownerName;
    private String ownerSurname;
    private BigDecimal amount;

    public Account(long id, String ownerName, String ownerSurname, BigDecimal amount) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.amount = amount.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public Account(long id, String ownerName, String ownerSurname) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
    }

    public long getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void addMoney(BigDecimal sum) {
        if (sum == null || sum.compareTo(new BigDecimal(0)) == -1) {
            throw new IllegalArgumentException();
        }
        amount = amount.add(sum);
    }

    public void withdraw(BigDecimal sum) {
        if (sum == null || (amount.min(sum).compareTo(new BigDecimal(0)) == -1)
                || (sum.compareTo(new BigDecimal(0)) == -1)) {
            throw new IllegalArgumentException();
        }

        amount = amount.min(sum);
    }
}
