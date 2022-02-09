package com.alevel.hw25.services;

import com.alevel.hw25.models.Film;
import com.alevel.hw25.models.Session;
import com.alevel.hw25.models.Ticket;
import com.alevel.hw25.models.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

public class EntityCreator {
    private static final Random rand = new Random();

    public static User createUser() {
        return new User("User" + rand.nextInt(10000), Date.valueOf(LocalDate.now()));
    }

    public static Film createFilm() {
        return new Film("Film" + rand.nextInt(10000), Date.valueOf(LocalDate.now()));
    }

    public static Session createSession(Film film) {
        return new Session(1000, rand.nextInt(11), film);
    }

    public static Ticket createTicket(Session session, User user) {
        return new Ticket(Date.valueOf(LocalDate.now()), rand.nextInt(10000), session, user);
    }
}
