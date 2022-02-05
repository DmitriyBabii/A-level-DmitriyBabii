package com.alevel.hw24;

import com.alevel.hw24.models.Device;
import com.alevel.hw24.serveces.ServiceHibernate;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        ServiceHibernate.start();
        System.out.println(ServiceHibernate.getDevices());
        System.out.println(ServiceHibernate.getFactories());

        Device device = ServiceHibernate.getDevice(2);
        System.out.println(device);
        System.out.println(ServiceHibernate.getFactory(2));

        if (device != null) {
            device.setDescription("Updated");
        }
        ServiceHibernate.updateDevice(device);
        System.out.println(ServiceHibernate.getDevices());

        if (device != null) {
            device.setDescription("Updated");
        }
        ServiceHibernate.deleteDevice(device);
        System.out.println(ServiceHibernate.getDevices());

        System.out.println(ServiceHibernate.getDevicesByFactoryId(1));

        ServiceHibernate.getFactoryInfo();
        System.out.println(ServiceHibernate.getDevices());

        ServiceHibernate.close();
    }
}
