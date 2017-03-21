package com.github.vlshat.epam.unit07.task01.entities;

import com.github.vlshat.epam.unit07.task01.exceptions.IllegalPaymentException;

import java.math.BigDecimal;

/**
 * Created by vladislav on 20.03.17.
 */
public class SynchronisedAccount extends Account {
    public SynchronisedAccount(long id, String ownerName, String ownerSurname, BigDecimal amount) {
        super(id, ownerName, ownerSurname, amount);
    }

    public SynchronisedAccount(long id, String ownerName, String ownerSurname) {
        super(id, ownerName, ownerSurname);
    }

    @Override
    public synchronized void addMoney(BigDecimal sum) throws IllegalPaymentException {
        super.addMoney(sum);
    }

    @Override
    public synchronized void withdraw(BigDecimal sum) throws IllegalPaymentException {
        super.withdraw(sum);
    }
}
