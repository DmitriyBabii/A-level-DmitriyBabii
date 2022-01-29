package com.alevel.hw24.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter
@Entity
@Table(name = "factory")
public class Factory {

    @Id
    @GeneratedValue
    private int idFactory;
    @Column
    private String nameFactory;
    @Column
    private Country country;

    @OneToMany(mappedBy = "factory")
    private Set<Device> deviceSet = new HashSet<>();

    public Factory(String nameFactory, Country country) {
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
            factories[i] = new Factory("Factory",
                    Country.values()[rand.nextInt(Country.values().length)]);
        }
        return factories;
    }

    @Override
    public String toString() {
        return "idFactory=" + idFactory +
                ", nameFactory='" + nameFactory + '\'' +
                ", country=" + country +
                "\n";
    }
}
