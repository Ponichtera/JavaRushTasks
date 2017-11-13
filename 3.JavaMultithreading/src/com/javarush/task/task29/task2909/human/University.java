package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private int age;
    private String name;
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for ( Student student : students)
            if (student.getAverageGrade() == averageGrade) return student;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student bestStudent = null;
        double maxAverageGrade = 0.0;
        for (Student student : students ) if (student.getAverageGrade() > maxAverageGrade) {
            maxAverageGrade = student.getAverageGrade();
            bestStudent = student;
        }
        return bestStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        Student worstStudent = null;
        double minAverageGrade = 9999;
        for (Student student : students ) if (student.getAverageGrade() < minAverageGrade) {
            minAverageGrade = student.getAverageGrade();
            worstStudent = student;
        }
        return worstStudent;
    }
    public void expel (Student student) {
        students.remove(student);
    }
}