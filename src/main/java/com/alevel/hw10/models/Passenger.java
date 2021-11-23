package com.alevel.hw10.models;

import java.util.Random;

public class Passenger {
    private final static Random RAND = new Random();
    private final static String[] NAMES = {
            "Oliver",
            "Jack",
            "Harry",
            "Jacob",
            "Charley",
            "Thomas",
            "George",
            "Oscar"
    };

    String name;
    int weight;

    Passenger() {
        this.name = NAMES[RAND.nextInt(NAMES.length)];
        this.weight = 50 + RAND.nextInt(51);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
