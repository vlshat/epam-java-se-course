package com.github.vlshat.epam.unit03.task01;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by wladislaw on 27.02.17.
 */
public class CrazyLogger {

    private StringBuilder builder = new StringBuilder();
    private int count = 0;


    /**
     * Method adds new log message with local date and time.
     * @param message
     */
    public void addMessage(String message) {

        LocalDateTime time = LocalDateTime.now();


        builder.append("\n");

        builder.append(time.getDayOfMonth())
                .append("-")
                .append(time.getMonthValue())
                .append("-")
                .append(time.getYear())
                .append(" : ")
                .append(time.getHour())
                .append("-")
                .append(time.getMinute())
                .append(" - ")
                .append(message);
        count += 1;
    }

    /**
     * Returns last message from log.
     * @return
     */
    public String getLastMessage() {

        if (builder.length() == 0)
            return "logger is empty";

        return builder.substring(builder.lastIndexOf("\n") + 1);
    }

    /**
     * Removes last message if it exists.
     */
    public void removeLastMessage() {

        if (count != 0){
            builder.delete(builder.lastIndexOf("\n"), builder.length());
            count -= 1;
        } else {
            throw new IllegalArgumentException("no messages in logger");
        }
    }

    public int getMessagesCount() {
        return count;
    }


    /**
     * Expects instance of LocalDate. Returns all log messages on this day.
     * @param date
     * @return
     */
    public String getByDate(LocalDate date) {

        String s = date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear();
        if (builder.indexOf(s) != -1){
            int rightBound = builder.lastIndexOf("\n", builder.lastIndexOf(s));
            if (rightBound != -1){
                rightBound = builder.length();
            }
            return builder.substring(builder.indexOf(s), rightBound);

        } else {
            return "no messages";
        }
    }

    public String getAllMessages(){
        return builder.toString();
    }
}
