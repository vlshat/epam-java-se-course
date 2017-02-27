package com.github.vlshat.epam.unit03.task01;

import org.junit.Test;

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
        logger.removeLastMessage();
        assertEquals("logger is empty", logger.getLastMessage());
    }

}