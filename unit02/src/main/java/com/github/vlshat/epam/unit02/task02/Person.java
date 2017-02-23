package com.github.vlshat.epam.unit02.task02;

import java.util.List;

/**
 * Created by wladislaw on 24.02.17.
 */
class Person {

    private String name;
    private String surname;
    private List<OfficeSupply> officeSupplies;

    Person(String name, String surname, List<OfficeSupply> officeSupplies) {
        this.name = name;
        this.surname = surname;
        this.officeSupplies = officeSupplies;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

    public List<OfficeSupply> getOfficeSupplies() {
        return officeSupplies;
    }

    public void setOfficeSupplies(List<OfficeSupply> officeSupplies) {
        this.officeSupplies = officeSupplies;
    }

    public void addOfficeSupply(OfficeSupply officeSupply){
        officeSupplies.add(officeSupply);
    }
}
