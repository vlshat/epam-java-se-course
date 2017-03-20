package com.github.vlshat.epam.unit07.task01;

import com.github.vlshat.epam.unit07.task01.entities.Transaction;

import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This class processes transactions.
 */
public class TransactionExecutor extends Thread {

    private Queue<Transaction> transactions = new PriorityQueue<>();
    private TransactionsApplication transactionsApplication;

    public TransactionExecutor(TransactionsApplication transactionsApplication) {
        this.transactionsApplication = transactionsApplication;
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

                transactionsApplication.commitTransaction(transactions.poll());
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
}
