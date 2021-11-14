package com.alevel.module1;

public class Lock {
    private final int[] mass;

    public Lock(int[] mass) {
        this.mass = mass;
    }

    public int[] getArray() {
        return (mass == null) ? null : mass.clone();
    }

    public void printArray() {
        for (int i : mass) {
            System.out.printf("%8d", i);
        }
        System.out.println();
    }
}
