package com.github.vlshat.epam.unit07.task01;

import com.github.vlshat.epam.unit07.task01.entities.Transaction;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * TransactionReader processes concrete file and creates Transaction object.
 */
public class TransactionReader extends Thread{

    private File file;
    private TransactionExecutor transactionExecutor;
    private DecimalFormat decimalFormat;

    public TransactionReader(File file, TransactionExecutor transactionExecutor) {
        this.file = file;
        this.transactionExecutor = transactionExecutor;
        decimalFormat = new DecimalFormat();
        decimalFormat.setParseBigDecimal(true);
    }

    @Override
    public void run() {
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String s = null;

            while ((s = reader.readLine()) != null) {
                String[] data = s.split(" ");
                transactionExecutor.addTransaction(new Transaction(Long.parseLong(data[0]),
                        Long.parseLong(data[1]),
                        (BigDecimal) decimalFormat.parse(data[2])));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }
}
