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
        String time1 = date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear();
        String time2 = date.minusDays(1).getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear();

        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("blah");
        logger.addMessage("blah2");
        logger.addMessage("blah3");

        String log = logger.getByDate(time1);
        assertTrue(log.contains("blah"));
        assertTrue(log.contains("blah2"));
        assertTrue(logger.getByDate(time2).equals("no messages"));

    }

}