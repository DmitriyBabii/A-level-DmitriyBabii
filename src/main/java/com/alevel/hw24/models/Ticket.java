package com.alevel.hw24.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "session")
    private String session;

    @Column(name = "users")
    private String user;

    @Column(name = "date")
    private Date date;

    @Column(name = "place")
    private String place;
}
