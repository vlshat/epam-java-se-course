package com.github.vlshat.epam.unit07.task01;

/**
 * Created by vladislav on 18.03.17.
 */
public class Transaction {

    private long operationId;
    private long senderNumber;
    private long recipientNumber;

    public Transaction(long operationId, long senderNumber, long recipientNumber) {
        this.operationId = operationId;
        this.senderNumber = senderNumber;
        this.recipientNumber = recipientNumber;
    }

    public long getOperationId() {
        return operationId;
    }

    public long getSenderNumber() {
        return senderNumber;
    }

    public long getRecipientNumber() {
        return recipientNumber;
    }
}
