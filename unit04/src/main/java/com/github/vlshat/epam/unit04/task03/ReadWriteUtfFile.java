package com.github.vlshat.epam.unit04.task03;

import java.io.*;

/**
 * Created by wladislaw on 05.03.17.
 */
public class ReadWriteUtfFile {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(
                new FileInputStream("text.unit04result"), "UTF8");

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream("test2.unit04result"), "UTF16");

        while (reader.ready()) {
            outputStreamWriter.write(reader.read());
        }

        reader.close();
        outputStreamWriter.close();
    }
}
