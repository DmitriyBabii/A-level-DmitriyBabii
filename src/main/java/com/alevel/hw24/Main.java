package com.alevel.hw24;

import com.alevel.hw24.serveces.ServiceHibernate;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        ServiceHibernate serviceHibernate = new ServiceHibernate();
        //SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
        //Session session = sessionFactory.openSession();
        //Query<Ticket> query = session.createQuery("FROM Ticket", Ticket.class);
        //List<Ticket> list = query.list();
        //System.out.println(list);
    }
}
