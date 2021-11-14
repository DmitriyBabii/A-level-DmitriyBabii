package com.alevel.module1;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int[] mass = createArray();
        System.out.println("Array:");
        fillRandomArray(mass);
        outputArray(mass);

        do {
            try {
                System.out.print("Enter 1 for sort to max and 2 to sort to min: ");
                int choose = Integer.parseInt(in.next());
                if (choose == 1) {
                    sortToMax(mass);
                } else if (choose == 2) {
                    sortToMin(mass);
                } else {
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("You need to enter int number!");
            }
        } while (true);
        System.out.println("Sorted array:");
        outputArray(mass);

        System.out.println("Array with degree:");
        powArray(mass);
        outputArray(mass);

        System.out.println("Lock array:");
        Lock lock = new Lock(mass);
        lock.getArray()[0] = 2;
        lock.printArray();
    }

    static int[] createArray() {
        final Scanner in = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter the number of elements in the array from 10: ");
                int length = Integer.parseInt(in.next());
                if (length >= 10) {
                    return new int[length];
                }
            } catch (Exception ex) {
                System.out.println("You need to enter int number!");
            }
        } while (true);
    }

    static void fillRandomArray(int[] mass) {
        final int range = 100;
        Random rand = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = -range + rand.nextInt(range * 2 + 1);
        }
    }

    static void outputArray(int[] mass) {
        for (int i : mass) {
            System.out.printf("%8d", i);
        }
        System.out.println();
    }

    static void sortToMax(int[] mass) {
        boolean sortSmt;

        do {
            sortSmt = false;
            for (int i = 0; i < mass.length - 1; i++) {
                if (mass[i] > mass[i + 1]) {
                    int tmp = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = tmp;
                    sortSmt = true;
                }
            }
        } while (sortSmt);
    }

    static void sortToMin(int[] mass) {
        sortToMax(mass);
        reverse(mass);
    }

    static void reverse(int[] mass) {
        int size = mass.length;
        for (int i = 0; i < size / 2; i++) {
            int tmp = mass[i];
            mass[i] = mass[size - 1 - i];
            mass[size - 1 - i] = tmp;
        }
    }

    static void powArray(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (i % 3 == 2) {
                mass[i] = pow(mass[i], 3);
            }
        }
    }

    static int pow(int value, int degree) {
        if (degree == 0) {
            return 1;
        }
        return value * pow(value, degree - 1);
    }
}
