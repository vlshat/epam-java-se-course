package com.github.vlshat.epam.unit04.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wladislaw on 05.03.17.
 */
public class CodeAnalyzer {

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();

        FileInputStream fileInputStream =
                new FileInputStream("src/main/java/com/github/vlshat/epam/unit04/task01/CodeAnalyzer.java");

        Map<String, Integer> base = getBase();

        while (fileInputStream.available() > 0) {

            int symbol = fileInputStream.read();

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

        fileInputStream.close();

        FileOutputStream fileOutputStream =
                new FileOutputStream("src/main/java/com/github/vlshat/epam/unit04/task01/result.unit04result");

        for (Map.Entry<String, Integer> m : base.entrySet()) {
            if (m.getValue() != 0) {
                fileOutputStream.write((m.getKey() + ":" + m.getValue() + "\n").getBytes());
            }
        }

        fileOutputStream.close();

    }

    public static Map<String, Integer> getBase() {
        Map<String, Integer> base = new HashMap<>();

        base.put("byte", 0);
        base.put("short", 0);
        base.put("int", 0);
        base.put("long", 0);
        base.put("char", 0);
        base.put("float", 0);
        base.put("double", 0);
        base.put("boolean", 0);
        base.put("if", 0);
        base.put("else", 0);
        base.put("switch", 0);
        base.put("case", 0);
        base.put("default", 0);
        base.put("while", 0);
        base.put("do", 0);
        base.put("break", 0);
        base.put("continue", 0);
        base.put("for", 0);
        base.put("try", 0);
        base.put("catch", 0);
        base.put("finally", 0);
        base.put("throw", 0);
        base.put("throws", 0);
        base.put("private", 0);
        base.put("protected", 0);
        base.put("public", 0);
        base.put("native", 0);
        base.put("import", 0);
        base.put("package", 0);
        base.put("class", 0);
        base.put("interface", 0);
        base.put("extends", 0);
        base.put("implements", 0);
        base.put("static", 0);
        base.put("final", 0);
        base.put("void", 0);
        base.put("abstract", 0);
        base.put("new", 0);
        base.put("return", 0);
        base.put("this", 0);
        base.put("super", 0);
        base.put("volatile", 0);
        base.put("synchronized", 0);
        base.put("const", 0);
        base.put("goto", 0);
        base.put("instanceof", 0);
        base.put("enum", 0);
        base.put("assert", 0);
        base.put("transient", 0);
        base.put("strictfp", 0);

        return base;
    }
}
