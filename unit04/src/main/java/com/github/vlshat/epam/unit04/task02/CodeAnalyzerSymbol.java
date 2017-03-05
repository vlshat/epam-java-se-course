package com.github.vlshat.epam.unit04.task02;

import com.github.vlshat.epam.unit04.task01.CodeAnalyzer;

import java.io.*;
import java.util.Map;

/**
 * Created by wladislaw on 05.03.17.
 */
public class CodeAnalyzerSymbol {

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();

        FileReader fileReader =
                new FileReader("src/main/java/com/github/vlshat/epam/unit04/task02/CodeAnalyzerSymbol.java");

        Map<String, Integer> base = CodeAnalyzer.getBase();

        while (fileReader.ready()) {

            int symbol = fileReader.read();

            if (symbol >= 97 && symbol <= 122) {
                builder.append((char) symbol);
            } else {

                String word = builder.toString();

                if (base.containsKey(word)) {
                    base.put(word, base.get(word) + 1);
                }

                builder.delete(0, builder.length());
            }
        }

        fileReader.close();

        FileWriter fileWriter =
                new FileWriter("src/main/java/com/github/vlshat/epam/unit04/task02/result.unit04result");

        for (Map.Entry<String, Integer> m : base.entrySet()) {
            if (m.getValue() != 0) {
                fileWriter.write(m.getKey() + ":" + m.getValue() + "\n");
            }
        }

        fileWriter.close();
    }
}
