package com.github.vlshat.epam.unit07.task01;

import com.github.vlshat.epam.unit07.task01.entities.Account;
import com.github.vlshat.epam.unit07.task01.entities.Transaction;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This class processes transactions.
 */
public class TransactionExecutor extends Thread {

    private Queue<Transaction> transactions = new PriorityQueue<>();
    private Map<Long, Account> accounts;

    public TransactionExecutor(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        while (true) {
            if (transactions.isEmpty()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {

                commitTransaction(transactions.poll());
            }
        }

    }

    /**
     * Adds transaction to the Queue.
     * @param transaction
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    /**
     * Executes transaction on accounts.
     * @param transaction
     */
    private void commitTransaction(Transaction transaction) {
        accounts.get(transaction.getSender()).withdraw(transaction.getSum());
        accounts.get(transaction.getRecipient()).addMoney(transaction.getSum());

    }
}
