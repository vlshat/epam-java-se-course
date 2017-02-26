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


    /**
     * Adds student to the group
     * @param student
     * @param mark - mark that real number or not (it depends on subject)
     */
    public void addStudent(Student student, Number mark) {

        if (!subject.markIsReal() && mark instanceof Double) {
            throw new IllegalArgumentException("Expected mark type: Integer, current mark: " + mark);
        } else {
            marks.put(student, mark);
        }

    }

    /**
     * @param id
     * @return
     */
    public boolean isStudentExists(String id) {

        for (Map.Entry<Student, Number> s : marks.entrySet()) {

            if (s.getKey().getSTUDENT_ID().equals(id)) {
                return true;
            }

        }
        return false;
    }

    /**
     * @param id
     * @return
     */
    public Student getStudentById(String id){

        if (!isStudentExists(id))
            throw new IllegalArgumentException("Such student doesn't exist");

        for (Map.Entry<Student, Number> s : marks.entrySet()){
            if (s.getKey().getSTUDENT_ID().equals(id)){
                return s.getKey();
            }
        }

        throw new IllegalArgumentException("Internal error");
    }

    /**
     * @param id
     * @return
     */
    public Number getMarkByStudentId(String id){
        if (!isStudentExists(id))
            throw new IllegalArgumentException("Such student doesn't exist");

        return marks.get(getStudentById(id));
    }

    /**
     * @return
     */
    public Subject getSubjectName(){
        return subject;
    }
}
