package com.alevel.hw24;

import com.alevel.hw24.models.Ticket;
import com.alevel.hw24.serveces.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Ticket> query = session.createQuery("FROM Ticket", Ticket.class);
        List<Ticket> list = query.list();
        System.out.println(list);
    }
}
