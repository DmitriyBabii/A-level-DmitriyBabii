package com.alevel.hw25.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Integer id;

    @Column
    private Date date;
    @Column
    private Integer numberOfSeat;

    @ManyToOne
    private Session session;
    @ManyToOne
    private User user;

    private Ticket() {
    }

    public Ticket(Date date, Integer numberOfSeat, Session session, User user) {
        this.date = date;
        this.numberOfSeat = numberOfSeat;
        this.session = session;
        this.user = user;
    }

    @Override
    public String toString() {
        return "date=" + date +
                ", numberOfSeat=" + numberOfSeat +
                ", session={\n" + session +
                "}, user=" + user + '\n';
    }
}
