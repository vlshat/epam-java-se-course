package com.github.vlshat.epam.unit02.task05;

import java.util.List;

/**
 * Created by wladislaw on 26.02.17.
 */
class StudentAnalyzer {

    private StudentAnalyzer(){
    }

    /**
     * This method returns marks of certain student
     * @param studentId
     * @return - List of marks as a string
     */
    public static String getMarks(String studentId, List<Group> groups){

        StringBuilder marks = new StringBuilder();

        for (Group group : groups){
            if (group.isStudentExists(studentId)){
                marks.append(group.getSubjectName() + ": ");
                marks.append(group.getMarkByStudentId(studentId) + "\n");
            }
        }

        return marks.toString();
    }
}
