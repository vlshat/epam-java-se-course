package com.github.vlshat.epam.unit03.task01;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by wladislaw on 27.02.17.
 */
public class CrazyLogger {

    private StringBuilder builder = new StringBuilder();


    public void addMessage(String message) {

        LocalDateTime time = LocalDateTime.now();


        builder.append("\n");

        builder.append(time.getDayOfMonth())
                .append("-")
                .append(time.getMonth())
                .append("-")
                .append(time.getYear())
                .append(" : ")
                .append(time.getHour())
                .append(time.getMinute())
                .append(" - ")
                .append(message);
    }

    public String getLastMessage() {

        if (builder.length() == 0)
            return "logger is empty";

        return builder.substring(builder.lastIndexOf("\n") + 1);
    }

    public void removeLastMessage() {

        builder.delete(builder.lastIndexOf("\n"), builder.length());
    }
}
