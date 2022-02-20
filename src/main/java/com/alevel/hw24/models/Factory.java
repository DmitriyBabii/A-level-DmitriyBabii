package com.alevel.hw24.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "factory")
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Integer idFactory;
    @Column
    private String nameFactory;
    @Column
    private Country country;

    @OneToMany//(/*fetch = FetchType.LAZY,*/ mappedBy = "factory")
    private Set<Device> deviceSet = new HashSet<>();

    private Factory() {
    }

    public Factory(String nameFactory, Country country) {
        this.nameFactory = nameFactory;
        this.country = country;
    }


    @Override
    public String toString() {
        return "idFactory=" + idFactory +
                ", nameFactory='" + nameFactory + '\'' +
                ", country=" + country +
                "\n";
    }
}
