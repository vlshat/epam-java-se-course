package com.github.vlshat.epam.unit03.task02;

import org.junit.Test;

import javax.management.Query;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 05.03.17.
 */
public class QuestionsTest {

    @Test
    public void testEnglishQuestions() throws Exception{
        Questions questions = new Questions(new Locale("ru"));

        assertEquals("1. The Ultimate Question of Life, the Universe, and Everything\n" +
                "2. What series to watch tonight?\n" +
                "3. What to read?\n", questions.getQuestions());
        assertEquals("42", questions.getAnswer(1));
        assertEquals("Scrubs or House of Cards", questions.getAnswer(2));

        assertEquals("Crime and Punishment", questions.getAnswer(3));
    }

    @Test
    public void testRussianQuestions() throws Exception{
        Questions questions = new Questions(new Locale("ru"));

        assertEquals("1. Главный вопрос Жизни, Вселенной и Всего Остального\n" +
                "2. Какой сериал посмотреть вечером?\n" +
                "3. Что почитать?\n", questions.getQuestions());
        assertEquals("42", questions.getAnswer(1));
        assertEquals("Клиника или Карточный Домик", questions.getAnswer(2));

        assertEquals("Преступление и наказание", questions.getAnswer(3));

    }



}