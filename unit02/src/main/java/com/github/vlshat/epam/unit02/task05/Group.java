package com.github.vlshat.epam.unit02.task05;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wladislaw on 26.02.17.
 */
public class Group {

    private Subject subject = Subject.MATH;
    private Map<Student, Number> marks = new HashMap<>();

    public Group(Subject subject) {
        this.subject = subject;
    }

    public void addStudent(Student student, Number mark) {

        if (!subject.markIsReal() && mark instanceof Double){
            throw new IllegalArgumentException("Expected mark type: Integer, current: " + mark);
        } else {
            marks.put(student, mark);
        }

    }

    public boolean isStudentExists(String name, String surname){
        boolean isExists = false;

        for (Map.Entry<Student, Number> s : marks.entrySet()){
            isExists = (s.getKey().getName().equals(name)
                    && s.getKey().getSurname().equals(surname));
            if (isExists)
                return true;
        }

        return isExists;
    }

    public boolean isStudentExists(Student student){
        return marks.containsKey(student);
    }

}
