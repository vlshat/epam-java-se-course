package com.github.vlshat.epam.unit03.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wladislaw on 05.03.17.
 */
public class QuestionsApplication {
    public static void main(String[] args) throws IOException {

        Questions questions = new Questions();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        System.out.println(questions.getQuestions());
        while ((s = bufferedReader.readLine()) != null){
            System.out.print("№: ");
            System.out.println(questions.getAnswer(Integer.parseInt(s)));
        }
    }
}
