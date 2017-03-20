package com.github.vlshat.epam.unit07.task01;

import java.io.File;

/**
 * Created by vladislav on 20.03.17.
 */
public class TransactionReader extends Thread{

    private File file;

    public TransactionReader(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        if (!file.exists()) {
            throw new IllegalArgumentException();
        }

        super.run();
    }
}
