package com.github.vlshat.epam.unit02.task05;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by wladislaw on 25.02.17.
 */
public class StudentsSubjectTest {

    List<Group> groups = new ArrayList<>();
    Student lisa = new Student("Lisa", "Edelstein");
    Student alex = new Student("Alex", "Flanders");
    Student klaus = new Student("Klaus", "Cruspe");
    Group mathGroup = new Group(Subject.MATH);
    Group philosophyGroup = new Group(Subject.PHILOSOPHY);
    Group algorithmsGroup = new Group(Subject.ALGORITHMS);

    @Before
    public void init() {
        mathGroup.addStudent(klaus, 5);
        mathGroup.addStudent(alex, 2);
        mathGroup.addStudent(lisa, 4);

        philosophyGroup.addStudent(lisa, 7.5);
        philosophyGroup.addStudent(alex, 8.2);

        algorithmsGroup.addStudent(klaus, 5);
        algorithmsGroup.addStudent(alex, 4);

        groups.add(mathGroup);
        groups.add(philosophyGroup);
        groups.add(algorithmsGroup);
    }

    @Test
    public void testGroupStudent() throws Exception {
        assertTrue(mathGroup.isStudentExists(klaus.getSTUDENT_ID()));
        assertTrue(algorithmsGroup.isStudentExists(klaus.getSTUDENT_ID()));
        assertFalse(philosophyGroup.isStudentExists(klaus.getSTUDENT_ID()));
    }

    @Test
    public void testStudentSeracher() throws Exception{
        StudentSearcher searcher = new StudentSearcher(groups);
        String studentMarks = searcher.getMarks(klaus.getSTUDENT_ID());
        StringBuilder expected = new StringBuilder();
        expected.append(Subject.MATH).append(": ").append(5).append("\n")
                .append(Subject.ALGORITHMS).append(": ").append(5).append("\n");
        assertEquals(expected.toString(), studentMarks);
        System.out.println(studentMarks);z
    }
}
