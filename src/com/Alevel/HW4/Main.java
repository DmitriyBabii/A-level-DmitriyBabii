package com.Alevel.HW4;

import java.util.Random;

class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] mass = new int[20];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = rand.nextInt(1000);
            System.out.printf("%5d", mass[i]);
        }
        System.out.println();
    }
}
