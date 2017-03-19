package com.github.vlshat.epam.unit07.task01;

/**
 * Created by vladislav on 20.03.17.
 */
public class Account {

    private long accountNumber;
    private String ownerName;
    private String ownerSurname;
    private long amount;

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public long getAmount() {
        return amount;
    }

    public Account(long accountNumber, String ownerName, String ownerSurname, long amount) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.amount = amount;

    }
}
