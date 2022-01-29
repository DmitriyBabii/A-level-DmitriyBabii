package com.alevel.hw24.serveces;

import org.hibernate.Session;

public class ServiceHibernate {
    private static Session session = HibernateUtil.getSessionFactory().openSession();


}
