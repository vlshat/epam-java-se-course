package com.github.vlshat.epam.unit07.task01;

import com.github.vlshat.epam.unit07.task01.TransactionExecutor;
import com.github.vlshat.epam.unit07.task01.TransactionReader;
import com.github.vlshat.epam.unit07.task01.entities.Account;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladislav on 20.03.17.
 */
public class TransactionsApplication {

    private Map<Long, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        
    }

    public void start() {
        TransactionExecutor transactionExecutor = new TransactionExecutor();
        transactionExecutor.start();
        TransactionReader transactionReader = new TransactionReader(new File("data/transactions.txt"), transactionExecutor);
        transactionReader.start();
    }

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }
}
