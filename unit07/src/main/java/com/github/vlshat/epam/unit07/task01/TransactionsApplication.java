package com.github.vlshat.epam.unit07.task01;

import com.github.vlshat.epam.unit07.task01.TransactionExecutor;
import com.github.vlshat.epam.unit07.task01.TransactionReader;
import com.github.vlshat.epam.unit07.task01.entities.Account;
import com.github.vlshat.epam.unit07.task01.entities.SynchronisedAccount;
import com.github.vlshat.epam.unit07.task01.entities.Transaction;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladislav on 20.03.17.
 */
public class TransactionsApplication {

    private Map<Long, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        new TransactionsApplication().start();
    }

    public void start() {
        addAccount(new SynchronisedAccount(1, "A", "A", new BigDecimal(20)));
        addAccount(new SynchronisedAccount(2, "B", "B", new BigDecimal(0)));
        addAccount(new SynchronisedAccount(3, "C", "C", new BigDecimal(0)));
        for (Map.Entry<Long, Account> a : accounts.entrySet()) {
            System.out.println(a);
        }
        TransactionExecutor transactionExecutor = new TransactionExecutor(this);
        transactionExecutor.start();
        TransactionReader transactionReader = new TransactionReader(new File("data/transactions.txt"), transactionExecutor);
        transactionReader.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Long, Account> a : accounts.entrySet()) {
            System.out.println(a);
        }
    }

    public void commitTransaction(Transaction transaction) {
        accounts.get(transaction.getSender()).withdraw(transaction.getSum());
        System.out.println(accounts.get(transaction.getSender()));
        accounts.get(transaction.getRecipient()).addMoney(transaction.getSum());
        System.out.println(accounts.get(transaction.getRecipient()));

    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
