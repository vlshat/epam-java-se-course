package com.github.vlshat.epam.unit04.task04;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by wladislaw on 05.03.17.
 */
public class Actor implements Serializable{

    private final String ID = UUID.randomUUID().toString();
    private String name;
    private String surname;

    public Actor(String name, String surname) {

        if (name == null || surname == null)
            throw new IllegalArgumentException("Arguments can not be null");

        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName(){
        return name + " " + surname;
    }
}
