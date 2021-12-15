package com.alevel.hw3;

import java.util.Scanner;

public class InputOutput {
    private final Scanner scanner;

    InputOutput() {
        this.scanner = new Scanner(System.in);
    }

    public int getInput() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.nextLine();
    }
}

