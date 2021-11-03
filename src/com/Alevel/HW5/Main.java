package com.Alevel.HW5;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();

    }

    /**
     * 1.Пользователь должен ввести с клавиатуры размер массива -
     * натуральное число больше 3. Введенное пользователем число
     * сохраняется в переменную input.
     * 2. Если пользователь ввёл не подходящее число, то программа должна
     * просить пользователя повторить ввод.
     * 3. Создать массив из случайных целых чисел из отрезка [0;input] и
     * вывести его на экран.
     * 4. Создать второй массив только из чётных элементов первого массива,
     * если они там есть, и вывести его на экран.
     */
    private static void task1() {
        System.out.println("TASK 1");
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int input;

        while (true) {
            try {
                System.out.print("Enter a number of elements in the array: ");
                input = Integer.parseInt(in.next());

                if (input <= 3) {
                    System.out.println("Your number must be more than 3!\n");
                    continue;
                }
                break;
            } catch (Exception ex) {
                System.out.println("You entered incorrect number!\n");
            }
        }

        int count = 0;
        int[] mass = new int[input];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = rand.nextInt(input + 1);
            System.out.printf(" %d ", mass[i]);

            if ((mass[i] & 1) == 0 && mass[i] != 0) {
                count++;
            }
        }
        System.out.println();

        int[] copyArray = new int[count];
        for (int i = 0, j = 0; i < mass.length && j < copyArray.length; i++) {
            if ((mass[i] & 1) == 0 && mass[i] != 0) {
                copyArray[j] = mass[i];
                System.out.printf(" %d ", copyArray[j]);
                j++;
            }
        }
        System.out.println();
    }

    /**
     * 1. Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5]
     * каждый
     * 2. Выведите массивы на экран в двух отдельных строках
     * 3. Посчитайте среднее арифметическое элементов каждого массива и
     * сообщите, для какого из массивов это значение оказалось больше
     * (либо сообщите, что их средние арифметические равны)
     */
    private static void task2() {
        System.out.println("\nTASK 2");
        Random rand = new Random();
        int[] mass1 = new int[5];
        int[] mass2 = new int[5];
        double average1 = 0.0, average2 = 0.0;

        for (int i = 0; i < 5; i++) {
            mass1[i] = rand.nextInt(6);
            average1 += mass1[i];
            mass2[i] = rand.nextInt(6);
            average2 += mass2[i];
        }
        System.out.println(Arrays.toString(mass1));
        System.out.println(Arrays.toString(mass2));

        if ((average1 /= 5) < (average2 /= 5)) {
            System.out.println("The average of the second array is greater");
        } else if (average1 > average2) {
            System.out.println("The average of the first array is greater");
        } else {
            System.out.println("The average mean of the first and second arrays are equal");
        }
    }

    /**
     * 1. Создайте массив из 4 случайных целых чисел из отрезка [10;99]
     * 2. Выведите его на экран в строку.
     * 3. Далее определите и выведите на экран сообщение о том, является ли
     * массив строго возрастающей последовательностью.
     */
    private static void task3() {
        System.out.println("\nTASK 3");
        Random rand = new Random();
        int[] mass = new int[4];
        boolean flag = true;

        for (int i = 0; i < mass.length; i++) {
            mass[i] = 10 + rand.nextInt(100 - 10);

            if (i > 0 && mass[i - 1] > mass[i]) {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(mass));

        if (flag) {
            System.out.println("Array is strictly ascending sequence");
        } else {
            System.out.println("Array is not strictly ascending sequence");
        }
    }

    /**
     * 1. Создайте массив из 8 случайных целых чисел из отрезка [1;10]
     * 2. Выведите массив на экран в строку
     * 3. Замените каждый элемент с нечётным индексом на ноль
     * 4. Снова выведете массив на экран на отдельной строке
     */
    private static void task4() {
        System.out.println("\nTASK 4");
        Random rand = new Random();
        int[] mass = new int[8];

        for (int i = 0; i < mass.length; i++) {
            mass[i] = 1 + rand.nextInt(10);
        }
        System.out.println(Arrays.toString(mass));

        for (int i = 1; i < mass.length; i += 2) {
            mass[i] = 0;
        }
        System.out.println(Arrays.toString(mass));
    }
}
