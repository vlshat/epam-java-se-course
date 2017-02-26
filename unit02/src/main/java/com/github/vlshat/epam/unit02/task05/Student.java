package com.github.vlshat.epam.unit02.task05;

import java.util.UUID;

/**
 * Created by wladislaw on 25.02.17.
 */
public class Student {

    private final String STUDENT_ID;
    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.STUDENT_ID = UUID.randomUUID().toString();
    }

    public String getSTUDENT_ID() {
        return STUDENT_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
