package com.github.vlshat.epam.unit07.task01;

/**
 * Created by vladislav on 18.03.17.
 */
public class Transaction {

    private int operationId;
    private String sender;
    private String recipient;

    public Transaction(int operationId, String sender, String recipient) {
        this.operationId = operationId;
        this.sender = sender;
        this.recipient = recipient;
    }

    public int getOperationId() {
        return operationId;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }
}
