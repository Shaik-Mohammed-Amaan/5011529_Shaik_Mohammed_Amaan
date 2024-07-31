package com.amaan;

import javax.swing.text.BoxView;
import javax.swing.text.View;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(101, "Ram", "A+");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();

        System.out.println("Updated details");
        controller.setStudentId(102);
        controller.setStudentName("Rajesh");
        controller.setStudentGrade("B");
        controller.updateView();

    }
}
