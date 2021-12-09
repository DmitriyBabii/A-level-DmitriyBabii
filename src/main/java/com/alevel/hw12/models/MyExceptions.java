package com.alevel.hw12.models;

public class MyExceptions {
    public static void g() {
        throw new MyException1();
    }

    public static void f() {
        try {
            g();
        } catch (MyException1 e) {
            System.out.println(e.getMessage());
            throw new MyException2();
        }
    }

    public static void throwAllMyExceptions() {
        try {
            f();
        } catch (MyException1 | MyException2 e) {
            System.out.println(e.getMessage());
            throw new MyException3();
        }
    }
}
