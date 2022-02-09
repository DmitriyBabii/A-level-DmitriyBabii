package com.alevel.hw25.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Integer id;

    @Column
    private String name;
    @Column
    private Date date;

    @OneToMany
    private Set<Session> sessions = new HashSet<>();

    private Film() {
    }

    public Film(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", date=" + date + '\n';
    }
}
