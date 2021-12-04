package com.alevel.hw12;

import com.alevel.hw12.models.MyExceptions;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //Пункт задания 1
        try {
            throw new RuntimeException("Main");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally");
        }

        //Пункт задания 2 и 3
        try {
            MyExceptions.throwAllMyExceptions();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(findNumber(generateNumbers(), "+380324826424"));
    }

    private static String[] generateNumbers() {
        return new String[]{
                "+380324826420",
                "+380324826421",
                "+380324826422",
                "+380324826423",
                "+380324826424",
                "+380324826425",
                "+380324826426",
                "+380324826427",
                "+380324826428",
                "+380324826429"
        };
    }

    private static Optional<Integer> findNumber(String[] numbers, String key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].equals(key)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
