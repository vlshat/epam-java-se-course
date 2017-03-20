package com.github.vlshat.epam.unit07.task01;

import com.github.vlshat.epam.unit07.task01.entities.Transaction;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by vladislav on 20.03.17.
 */
public class TransactionExecutor extends Thread {

    private Queue<Transaction> transactions = new PriorityQueue<>();
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
                System.out.println(transactions.poll());
            }
        }

    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
