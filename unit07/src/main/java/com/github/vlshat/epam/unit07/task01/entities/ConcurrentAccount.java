package com.github.vlshat.epam.unit07.task01.entities;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vladislav on 20.03.17.
 */
public class ConcurrentAccount extends Account{

    private Lock lock = new ReentrantLock();

    public ConcurrentAccount(long id, String ownerName, String ownerSurname, BigDecimal amount) {
        super(id, ownerName, ownerSurname, amount);
    }

    public ConcurrentAccount(long id, String ownerName, String ownerSurname) {
        super(id, ownerName, ownerSurname);
    }

    @Override
    public void addMoney(BigDecimal sum) {
        lock.lock();
        super.addMoney(sum);
        lock.unlock();
    }

    @Override
    public void withdraw(BigDecimal sum) {
        lock.lock();
        super.withdraw(sum);
        lock.unlock();
    }
}
