package com.amaan;

public class StudentController {
    private Student student;
    private StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudentId(int id) {
        student.setId(id);
    }

    public int getStudentId() {
        return student.getId();
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentGrade(String grade) {
        student.setName(grade);
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(student.getId(), student.getName(), student.getGrade());
    }
}
