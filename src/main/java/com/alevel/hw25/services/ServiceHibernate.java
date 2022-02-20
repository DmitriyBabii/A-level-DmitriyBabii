package com.alevel.hw25.services;

import com.alevel.hw25.models.Film;
import com.alevel.hw25.models.Ticket;
import com.alevel.hw25.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceHibernate {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session;

    private static void open() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    private static void closeSession() {
        session.getTransaction().commit();
        session.close();
    }

    public static void close() {
        sessionFactory.close();
    }

    public static void start() {
        open();

        User user;
        Film film;
        com.alevel.hw25.models.Session userSession;

        for (int i = 0; i < 50; i++) {
            user = EntityCreator.createUser();
            session.save(user);
            film = EntityCreator.createFilm();
            session.save(film);
            userSession = EntityCreator.createSession(film);
            session.save(userSession);
            session.save(EntityCreator.createTicket(userSession, user));
        }

        closeSession();
    }

    public static List<com.alevel.hw25.models.Session> getSessions() {
        open();

        List<com.alevel.hw25.models.Session> sessions = session.createQuery("from com.alevel.hw25.models.Session",
                com.alevel.hw25.models.Session.class)
                .getResultList();

        closeSession();
        return sessions;
    }

    public static List<com.alevel.hw25.models.User> getUsers() {
        open();

        List<com.alevel.hw25.models.User> users = session.createQuery("from com.alevel.hw25.models.User",
                com.alevel.hw25.models.User.class)
                .getResultList();

        closeSession();
        return users;
    }

    public static List<com.alevel.hw25.models.Film> getFilms(String find) {
        open();

        Query<com.alevel.hw25.models.Film> query = session.createQuery(
                "from com.alevel.hw25.models.Film where name like :find",
                com.alevel.hw25.models.Film.class);

        query.setParameter("find", "%" + find + "%");
        List<com.alevel.hw25.models.Film> films = query.getResultList();

        closeSession();
        return films;
    }

    public static List<com.alevel.hw25.models.Ticket> getUsersTickets(User user) {
        open();

        Query<com.alevel.hw25.models.Ticket> query = session.createQuery(
                "from com.alevel.hw25.models.Ticket where user= :user", com.alevel.hw25.models.Ticket.class);
        query.setParameter("user", user);
        List<com.alevel.hw25.models.Ticket> tickets = query.getResultList();

        closeSession();
        return tickets;
    }

    public static void addUser(User user) {
        open();
        session.save(user);
        closeSession();
    }

    public static void addFilm(Film film) {
        open();
        session.save(film);
        closeSession();
    }

    public static void addSession(com.alevel.hw25.models.Session userSession) {
        open();
        session.save(userSession);
        closeSession();
    }

    public static void addTicket(Ticket ticket) {
        open();
        session.save(ticket);
        closeSession();
    }

    public static void deleteUser(User user) {
        open();
        session.delete(user);
        closeSession();
    }

    public static void deleteFilm(Film film) {
        open();
        session.delete(film);
        closeSession();
    }

    public static void deleteSession(com.alevel.hw25.models.Session userSession) {
        open();
        session.delete(userSession);
        closeSession();
    }

    public static void deleteTicket(Ticket ticket) {
        open();
        session.delete(ticket);
        closeSession();
    }
}
