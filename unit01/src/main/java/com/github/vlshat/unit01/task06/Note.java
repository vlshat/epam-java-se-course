package com.github.vlshat.unit01.task06;

import java.time.LocalDate;

/**
 * Created by wladislaw on 26.02.17.
 */
public class Note {

    private String text;
    private LocalDate date;

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
