package com.github.vlshat.epam.unit03.task01;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

/**
 * Created by wladislaw on 27.02.17.
 */
public class CrazyLoggerTest {

    @Test
    public void testThatLoggerAddsAndDeletesMessages() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        String message = "testing last message";

        assertEquals("no messages", logger.getLastMessage());
        assertEquals("no messages", logger.getAllMessages());
        logger.addMessage(message);
        assertTrue(logger.getLastMessage().contains(message));
        assertTrue(logger.getMessagesCount() == 1);
        logger.removeLastMessage();
        assertEquals("no messages", logger.getLastMessage());
        assertTrue(logger.getMessagesCount() == 0);
    }

    @Test
    public void testLoggerSearchMethods() throws Exception {

        LocalDate date = LocalDate.now();

        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("blah");
        logger.addMessage("blah2");

        String log = logger.getByDate(LocalDate.now());
        assertTrue(log.contains("blah"));
        assertTrue(log.contains("blah2"));
        assertTrue(logger.getByDate(LocalDate.now().minusDays(1)).equals("no messages"));

    }

    @Test
    public void testWhereMentionedMethod() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        String expected1 = "blah1";
        String expected2 = "blah2";
        String expected3 = "blah3";

        logger.addMessage(expected1);
        logger.addMessage(expected2);
        logger.addMessage("wowowow");
        logger.addMessage(expected3);

        String log = logger.getWhereMentioned("blah");
        System.out.println(logger.getAllMessages());
        System.out.println(log);

        assertTrue(log.contains(expected1) &&
                log.contains(expected2) && log.contains(expected3));

    }

}