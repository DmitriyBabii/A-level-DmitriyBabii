package com.alevel.hw24.serveces;

import com.alevel.hw24.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class ServiceHibernate {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static Session session;
    private static boolean isSessionFactoryClosed = false;

    private ServiceHibernate() {

    }

    private static void open() {
        if (isSessionFactoryClosed) {
            System.out.println("Session factory was closed");
            return;
        }
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    private static void closeSession() {
        session.getTransaction().commit();
        session.close();
    }

    private static void closeSessionFactory() {
        sessionFactory.close();
        isSessionFactoryClosed = true;
    }

    public static void close() {
        closeSessionFactory();
    }

    public static void start() {
        open();

        Random rand = new Random();
        int countryLength = Country.values().length;
        int deviceTypeLength = DeviceType.values().length;

        for (int i = 1; i <= 4; i++) {
            Factory factory = new Factory("Factory" + i,
                    Country.values()[rand.nextInt(countryLength)]);
            session.save(factory);

            for (int j = 0; j < 3; j++) {
                Device device = new Device(DeviceType.values()[rand.nextInt(deviceTypeLength)]
                        , "Model", rand.nextInt(50000),
                        Date.valueOf(LocalDate.now()), "Description", true, factory);
                session.save(device);
            }
        }

        closeSession();
    }

    public static List<Device> getDevices() {
        open();

        List<Device> deviceList = session.createQuery("from Device", Device.class).getResultList();

        closeSession();
        return deviceList;
    }

    public static List<Factory> getFactories() {
        open();

        List<Factory> factoryList = session.createQuery("from Factory", Factory.class).getResultList();

        closeSession();
        return factoryList;
    }

    public static Device getDevice(int id) {
        open();

        Device device = null;
        try {
            Query<Device> query = session.createQuery("from Device where idDevice= :idDevice", Device.class);
            query.setParameter("idDevice", id);
            device = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        closeSession();
        return device;
    }

    public static Factory getFactory(int id) {
        open();

        Factory factory = null;
        try {
            Query<Factory> query = session.createQuery("from Factory where idFactory= :idFactory", Factory.class);
            query.setParameter("idFactory", id);
            factory = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }

        closeSession();
        return factory;
    }

    public static void updateDevice(Device device) {
        open();
        session.update(device);
        closeSession();
    }

    public static void deleteDevice(Device device) {
        open();
        session.delete(device);
        closeSession();
    }

    public static List<Device> getDevicesByFactoryId(int id) {
        open();

        Query<Device> query = session.createQuery("FROM Device as device INNER JOIN FETCH device.factory " +
                "WHERE device.factory.idFactory = :idFactory", Device.class);
        query.setParameter("idFactory", id);
        List<Device> devices = query.list();
        closeSession();

        return devices;
    }

    public static void getFactoryInfo() {
        open();

        Query<DataFactory> query = session.createQuery("SELECT " +
                "new com.alevel.hw24.models.DataFactory(dev.factory.nameFactory, SUM(dev.price), COUNT(dev.idDevice)) " +
                "FROM Device as dev GROUP BY dev.factory.idFactory", DataFactory.class);

        List<DataFactory> list = query.list();
        for (DataFactory dataFactory : list) {
            System.out.println(dataFactory);
        }

        closeSession();
    }
}

