package com.alevel.module1;

final class Lock {
    private final int[] mass;

    public Lock(int[] mass) {
        this.mass = mass;
    }

    public final int[] getArray() {
        return (mass == null) ? null : mass.clone();
    }

    public final void printArray() {
        for (int i : mass) {
            System.out.printf("%8d", i);
        }
        System.out.println();
    }
}
