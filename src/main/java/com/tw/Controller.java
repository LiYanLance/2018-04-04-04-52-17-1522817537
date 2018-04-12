package com.tw;

import java.util.*;

public class Controller {

    private StudentService studentService = new StudentService();
    private View view;
    private InputHandler inputHandler;

    public Controller(View view, InputHandler inputHandler) {
        this.view = view;
        this.inputHandler = inputHandler;
    }

    public void addStudentInfo() {
        boolean addSuccessed = false;
        while(!addSuccessed){
            Student student = inputHandler.getStudentInfoInput();
            String message = Config.WRONG_FORMAT_OF_STUDENT_INFO;
            if(student != null){
                studentService.addStudent(student);
                addSuccessed = true;
                message = "学生" + student.getName() + "的成绩被添加";
            }
            view.printlnMessage(message);
        }
    }


    public void buildReport() {
        boolean showSuccessed = false;
        while(!showSuccessed){
            List<String> studentsIds = inputHandler.getStudentIdsInput();
            if (studentsIds == null) {
                view.printlnMessage(Config.WRONG_FORMAT_OF_STUDENT_ID);
            } else {
                showSuccessed = true;
                view.printReport(studentService.getStudentsSheet(studentsIds),
                        studentService.getAverageOfAllStudents(), studentService.getMedianOfAllStudents());
            }
        }
    }

}
