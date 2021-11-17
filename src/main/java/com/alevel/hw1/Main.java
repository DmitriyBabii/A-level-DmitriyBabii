package com.alevel.hw1;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        enterName();
        stepAndValue();
    }

    static void enterName() {
        System.out.print("Enter your name: ");
        String name = new Scanner(System.in).next();
        System.out.print("Enter your surname: ");
        String surname = new Scanner(System.in).next();

        System.out.println(surname + " " + name);

        if (name.length() > 7) {
            System.out.println("more than 7");
        } else if (name.length() < 7) {
            System.out.println("lass than 7");
        } else {
            System.out.println("equals 7");
        }
        System.out.println();
    }

    static void stepAndValue() {
        for (int i = 0, count = 5; i < 10; i++) {
            System.out.printf("Step %d, value %d\n", i, count);
            count += 2;
        }
        System.out.println();
    }

}