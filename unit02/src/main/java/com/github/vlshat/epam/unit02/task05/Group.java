package com.github.vlshat.epam.unit02.task05;

import com.github.vlshat.epam.unit02.task05.markcomparators.DoubleMarkComparator;
import com.github.vlshat.epam.unit02.task05.markcomparators.IntegerMarkComparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wladislaw on 26.02.17.
 */
class Group {

    private Subject subject;
    private Map<String, Number> marks = new HashMap<>();
    private Map<String, Student> students = new HashMap<>();

    public Group(Subject subject) {
        this.subject = subject;
    }


    /**
     * Adds student to the group
     * @param student
     * @param mark - mark that real number or not (it depends on subject)
     */
    public void addStudent(Student student, Number mark) {

        if (student == null || mark == null)
            throw new IllegalArgumentException("Arguments can't be null");

        if (!subject.markIsReal() && mark instanceof Double) {
            throw new IllegalArgumentException("Expected mark type: Integer, current mark: " + mark);
        } else {
            marks.put(student.getSTUDENT_ID(), mark);
            students.put(student.getSTUDENT_ID(), student);
        }
    }

    /**
     * @param id
     * @return
     */
    public boolean isStudentExists(String id) {

        return students.containsKey(id);
    }

    /**
     * @param id
     * @return
     */
    public Student getStudentById(String id){

        if (!isStudentExists(id))
            throw new IllegalArgumentException("Such student doesn't exist");

        return students.get(id);
    }

    /**
     * @param id
     * @return
     */
    public Number getMarkByStudentId(String id){
        if (!isStudentExists(id))
            throw new IllegalArgumentException("Such student doesn't exist");

        return marks.get(id);
    }

    public String getTopStudent(){

        Comparator markComparator;
        Number highMark;

        if (subject.markIsReal()){
            markComparator = new DoubleMarkComparator();
            highMark = -1d;
        } else {
            markComparator = new IntegerMarkComparator();
            highMark = -1;
        }

        String studentId = null;

        for (Map.Entry<String, Number> mark : marks.entrySet()){

            if (markComparator.compare(highMark, mark.getValue()) == -1){
                studentId = mark.getKey();
                highMark = mark.getValue();
            }
        }

        return new StringBuilder().append(subject)
                .append(": ")
                .append(students.get(studentId).getName())
                .append(" ")
                .append(students.get(studentId).getSurname())
                .append(" ")
                .append(highMark).toString();
    }

    /**
     * @return
     */
    public Subject getSubjectName(){
        return subject;
    }

    public Map<String, Number> getMarks() {
        Map<String, Number> copy = new HashMap<>();
        copy.putAll(marks);
        return copy;
    }

    public Map<String, Student> getStudents() {
        Map<String, Student> copy = new HashMap<>();
        copy.putAll(students);
        return copy;
    }



}
