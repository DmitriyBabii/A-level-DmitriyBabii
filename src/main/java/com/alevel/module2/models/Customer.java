package com.alevel.module2.models;

public class Customer {
    private String id;
    private String email;
    private int age;

    public Customer(String id, String email, int age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("id = %s\nemail = %s\nage = %s\n", id, email, age);
    }
}
