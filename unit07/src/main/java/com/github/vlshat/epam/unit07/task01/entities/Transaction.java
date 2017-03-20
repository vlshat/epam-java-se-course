package com.github.vlshat.epam.unit07.task01.entities;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by vladislav on 20.03.17.
 */
public class Transaction {

    private String transactionId = UUID.randomUUID().toString();
    private long sender;
    private long recipient;
    private BigDecimal sum;

    public Transaction(long sender, long recipient, BigDecimal sum) {
        this.sender = sender;
        this.recipient = recipient;
        this.sum = sum.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public long getSender() {
        return sender;
    }

    public long getRecipient() {
        return recipient;
    }

    public BigDecimal getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return sender + " " + recipient + " " + sum.toString();
    }
}
