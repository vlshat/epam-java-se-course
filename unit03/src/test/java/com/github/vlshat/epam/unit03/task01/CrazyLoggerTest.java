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
    public void testLoggerBaseMethods() throws Exception{
        CrazyLogger logger = new CrazyLogger();
        String message = "testing last message";
        logger.addMessage(message);

        assertTrue(logger.getLastMessage().contains(message));
        assertTrue(logger.getMessagesCount() == 1);
        logger.removeLastMessage();
        assertEquals("logger is empty", logger.getLastMessage());
        assertTrue(logger.getMessagesCount() == 0);
    }

    @Test
    public void testSearchMethods() throws Exception{

        LocalDate date = LocalDate.now();

        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("blah");
        logger.addMessage("blah2");

        String log = logger.getByDate(LocalDate.now());
        assertTrue(log.contains("blah"));
        assertTrue(log.contains("blah2"));
        assertTrue(logger.getByDate(LocalDate.now().minusDays(1)).equals("no messages"));

    }

}