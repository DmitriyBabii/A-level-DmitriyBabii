package com.alevel.hw16;

public class Node {
    private Student student;
    private Node next;
    private Node prev;

    public Node(Student student) {
        this.student = student;
    }

    public Node(Student student, Node next, Node prev) {
        this.student = student;
        this.next = next;
        this.prev = prev;
    }

    public Student getStudent() {
        return student;
    }

    public Node getNext() {
        return next;
    }

    private void setNext(Node next) {
        this.next = next;
    }

    public void add(Student student) {
        if (next != null) {
            next.add(student);
        } else {
            next = new Node(student, null, this);
        }
    }

    public void remove() {
        if (student.getGrades() < 3) {
            if (next != null) {
                student = next.getStudent();
                next = next.getNext();
                this.remove();
            } else if (prev != null) {
                prev.setNext(null);
            } else {
                student = null;
            }
        }
        if (next != null) {
            next.remove();
        }
    }

    public void nextCourse() {
        if (student.getGrades() >= 3) {
            student.nextCourse();
        }
        if (next != null) {
            next.nextCourse();
        }
    }

    @Override
    public String toString() {
        return student.toString() +
                "\n" + ((next != null) ? next : "");
    }
}
