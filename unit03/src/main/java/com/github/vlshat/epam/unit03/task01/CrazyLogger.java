package com.github.vlshat.epam.unit03.task01;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by wladislaw on 27.02.17.
 */
public class CrazyLogger {

    private StringBuilder builder = new StringBuilder();
    private final String TEXT_NO_MESSAGES = "no messages";
    private int count = 0;
    /**
     * Method adds new log message with local date and time.
     *
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
                .append(message)
                .append(";");
        count += 1;
    }

    /**
     * Returns last message from log.
     *
     * @return
     */
    public String getLastMessage() {

        if (builder.length() == 0)
            return TEXT_NO_MESSAGES;

        return builder.substring(builder.lastIndexOf("\n") + 1);
    }

    /**
     * Removes last message if it exists.
     */
    public void removeLastMessage() {

        if (count != 0) {
            builder.delete(builder.lastIndexOf("\n"), builder.length());
            count -= 1;
        } else {
            throw new IllegalArgumentException(TEXT_NO_MESSAGES);
        }
    }

    public int getMessagesCount() {
        return count;
    }


    /**
     * Expects instance of LocalDate. Returns all log messages on this day.
     *
     * @param date
     * @return
     */
    public String getByDate(LocalDate date) {

        String s = date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear();
        if (builder.indexOf(s) != -1) {
            int rightBound = builder.lastIndexOf("\n", builder.lastIndexOf(s));
            if (rightBound != -1) {
                rightBound = builder.length();
            }
            return builder.substring(builder.indexOf(s), rightBound);

        } else {
            return TEXT_NO_MESSAGES;
        }
    }

    /**
     * Returns all whole log as a string
     *
     * @return
     */
    public String getAllMessages() {
        if (builder.length() == 0){
            return TEXT_NO_MESSAGES;
        }
        return builder.toString();
    }

    /**
     * Returns all messages where mentioned fragment
     * @param fragment
     * @return
     */
    public String getWhereMentioned(String fragment) {

        StringBuilder result = new StringBuilder();
        int leftBound = 0;

        if (builder.indexOf(fragment) == -1)
            return TEXT_NO_MESSAGES;

        while ((leftBound = builder.indexOf(fragment, leftBound)) != -1){
            result.append(builder.substring(getStringStartPosition(leftBound),
                    builder.indexOf(";", leftBound) + 1));
            leftBound = builder.indexOf(";", leftBound);
        }

        return result.toString();
    }

    private int getStringStartPosition(int point) {

        int index = 1;

        while (true){
            if (builder.indexOf("\n", index) >= point || builder.indexOf("\n", index) == -1){
                break;
            }

            index = builder.indexOf("\n", index) + 1;
        }
        return index - 1;
    }
}
