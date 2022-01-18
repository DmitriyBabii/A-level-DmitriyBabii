package com.alevel.hw23.models;

import lombok.Getter;

import java.util.Random;

@Getter
public class Factory {
    private static int countFactory = 0;

    private int idFactory;
    private String nameFactory;
    private Country country;

    public Factory(String nameFactory, Country country) {
        this.idFactory = ++countFactory;
        this.nameFactory = nameFactory;
        this.country = country;
    }

    public Factory(int idFactory, String nameFactory, Country country) {
        this.idFactory = idFactory;
        this.nameFactory = nameFactory;
        this.country = country;
    }

    public static Factory[] createFactories(int n) {
        if (n < 0) {
            return null;
        }
        Random rand = new Random();
        Factory[] factories = new Factory[n];
        for (int i = 0; i < n; i++) {
            factories[i] = new Factory("Factory" + (Factory.countFactory + 1),
                    Country.values()[rand.nextInt(Country.values().length)]);
        }
        return factories;
    }

    public static void setCountFactory(int countFactory) {
        Factory.countFactory = countFactory;
    }

    @Override
    public String toString() {
        return "idFactory=" + idFactory +
                ", nameFactory='" + nameFactory + '\'' +
                ", country=" + country +
                "\n";
    }
}
