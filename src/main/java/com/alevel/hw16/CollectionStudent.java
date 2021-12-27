package com.alevel.hw16;

import java.util.List;

public class CollectionStudent {
    private Node student;

    public CollectionStudent() {
    }

    public CollectionStudent(Student student) {
        this.student = new Node(student);
    }


    public Student getStudent() {
        return student.getStudent();
    }

    public void add(Student student) {
        if (this.student != null) {
            this.student.add(student);
        } else {
            this.student = new Node(student);
        }
    }

    public void deduct() {
        if (student != null) {
            student.remove();
        }
    }

    public void nextCourse() {
        student.nextCourse();
    }

    public static void printStudents(List<Student> student, int course) {
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getCourse() == course) {
                System.out.println(student.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return student.toString();
    }
}
