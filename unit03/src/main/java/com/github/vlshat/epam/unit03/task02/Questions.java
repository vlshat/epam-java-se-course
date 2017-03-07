package com.github.vlshat.epam.unit03.task02;

import java.util.*;

/**
 * Created by wladislaw on 04.03.17.
 */
public class Questions {

    private ResourceBundle bundle;
    private Scanner scanner = new Scanner(System.in);
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();

    public Questions() {
        initBundle();
        getKeys();
    }

    public Questions(Locale locale) {
        bundle = ResourceBundle.getBundle("question", locale);
        getKeys();
    }

    private void initBundle() {

        System.out.println("Choose language:");
        System.out.println("1. English");
        System.out.println("2. Russian");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                bundle = ResourceBundle.getBundle("question", Locale.ENGLISH);
                break;
            case 2:
                bundle = ResourceBundle.getBundle("question", new Locale("ru"));
                break;
            default:
                throw new IllegalArgumentException("Such option doesn't exist");
        }
    }

    private void getKeys() {

        Enumeration<String> k = bundle.getKeys();

        while (k.hasMoreElements()) {
            String key = k.nextElement();
            if (key.contains("q")) {
                questions.add(key);
            } else {
                answers.add(key);
            }
        }
    }

    public String getQuestions() {

        int number = 1;
        StringBuilder builder = new StringBuilder();

        for (String q : questions) {
            builder.append(number)
                    .append(". ")
                    .append(bundle.getString(q))
                    .append("\n");
            number += 1;
        }

        return builder.toString();
    }

    public String getAnswer(int number) {

        if (number < 0 || number > answers.size())
            throw new IllegalArgumentException("No such answer");

        return bundle.getString(answers.get(number - 1));
    }
}
