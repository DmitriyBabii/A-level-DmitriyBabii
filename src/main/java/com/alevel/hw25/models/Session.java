package com.alevel.hw25.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Integer id;

    @Column
    private Integer numberOfSeats;
    @Column
    private Integer roomNumber;

    @OneToMany
    private Set<Ticket> tickets = new HashSet<>();
    @ManyToOne
    @JoinColumn
    private Film film;

    public Session() {
    }

    public Session(Integer numberOfSeats, Integer roomNumber, Film film) {
        this.numberOfSeats = numberOfSeats;
        this.roomNumber = roomNumber;
        this.film = film;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
                ", roomNumber=" + roomNumber +
                ", film={\n" + film + "}\n";
    }
}
