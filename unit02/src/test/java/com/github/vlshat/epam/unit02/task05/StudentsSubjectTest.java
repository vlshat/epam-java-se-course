package com.github.vlshat.epam.unit02.task05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by wladislaw on 25.02.17.
 */
public class StudentsSubjectTest {

    @Test
    public void test() throws Exception{
        List<Group> groups = new ArrayList<>();
        Student klaus = new Student("Klaus", "Cruspe");

        Group mathGroup = new Group(Subject.MATH);
        mathGroup.addStudent(klaus, 5);
        mathGroup.addStudent(new Student("Alex", "Flanders"), 2);
        mathGroup.addStudent(new Student("Lisa", "Edelstein"), 4);

        Group philosophyGroup = new Group(Subject.PHILOSOPHY);
        philosophyGroup.addStudent(new Student("Lisa", "Edelstein"), 7.5);
        philosophyGroup.addStudent(new Student("Alex", "Flanders"), 8.2);

        Group algorithmsGroup = new Group(Subject.ALGORITHMS);
        algorithmsGroup.addStudent(new Student("Klaus", "Cruspe"), 5);
        algorithmsGroup.addStudent(new Student("Alex", "Flanders"), 4);


        groups.add(mathGroup);
        groups.add(philosophyGroup);
        groups.add(algorithmsGroup);

        assertTrue(mathGroup.isStudentExists("Klaus", "Cruspe"));


    }
}
