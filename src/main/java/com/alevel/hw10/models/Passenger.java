package com.alevel.hw10.models;

import java.util.Random;

public class Passenger {
    private final static Random rand = new Random();
    private final static String[] names = {
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
        this.name = names[rand.nextInt(names.length)];
        this.weight = 50 + rand.nextInt(51);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
