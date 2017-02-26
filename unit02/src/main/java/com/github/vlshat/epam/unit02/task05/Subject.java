package com.github.vlshat.epam.unit02.task05;

/**
 * Created by wladislaw on 25.02.17.
 */
public enum Subject {
    MATH(false),
    ALGORITHMS(false),
    JAVA(true),
    PHILOSOPHY(true);

    private boolean markIsReal;

    Subject(boolean markIsReal) {
        this.markIsReal = markIsReal;
    }

    public boolean markIsReal(){
        return markIsReal;
    }

}
