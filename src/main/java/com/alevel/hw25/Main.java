package com.alevel.hw25;

import com.alevel.hw25.models.Film;
import com.alevel.hw25.models.Session;
import com.alevel.hw25.models.Ticket;
import com.alevel.hw25.models.User;
import com.alevel.hw25.services.EntityCreator;
import com.alevel.hw25.services.ServiceHibernate;

public class Main {
    public static void main(String[] args) {
        outputMethods();
        createAndDeleteMethods();
        ServiceHibernate.close();
    }

    private static void outputMethods() {
        ServiceHibernate.start();
        System.out.println("Sessions:\n" + ServiceHibernate.getSessions());
        System.out.println("Users:\n" + ServiceHibernate.getUsers());

        System.out.println("Films:\n" + ServiceHibernate.getFilms("1"));
        System.out.println("Tickets:\n" + ServiceHibernate.getUsersTickets(
                ServiceHibernate.getUsers().get(0)
        ));
    }

    private static void createAndDeleteMethods() {
        User user;
        Film film;
        Session session;
        Ticket ticket;
        ServiceHibernate.addUser((user = EntityCreator.createUser()));
        ServiceHibernate.addFilm((film = EntityCreator.createFilm()));
        ServiceHibernate.addSession((session = EntityCreator.createSession(film)));
        ServiceHibernate.addTicket((ticket = EntityCreator.createTicket(session, user)));

        ServiceHibernate.deleteTicket(ticket);
        ServiceHibernate.deleteSession(session);
        ServiceHibernate.deleteFilm(film);
        ServiceHibernate.deleteUser(user);
    }
}
