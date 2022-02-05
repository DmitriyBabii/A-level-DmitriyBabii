package com.alevel.hw23;

import com.alevel.hw23.models.Device;
import com.alevel.hw23.models.Factory;
import com.alevel.hw23.services.ServiceSQL;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ServiceSQL serviceSQL = new ServiceSQL();
        serviceSQL.start();
        //Factory[] factories = Factory.createFactories(5);
        //serviceSQL.insertFactories(factories);
        //serviceSQL.insertDevices(Device.createDevices(factories));

        System.out.println(serviceSQL.readAllFactories());
        System.out.println("\n" + serviceSQL.readAllDevice());
        System.out.println("\nBy id:\n" + serviceSQL.getInfoById(10));
        serviceSQL.updateDeviceById(10);
        System.out.println("\nBy id:\n" + serviceSQL.getInfoById(10));
        serviceSQL.deleteDeviceById(10);
        System.out.println(serviceSQL.getDevicesByFactoryId(5));
        serviceSQL.factoryInfo();

        serviceSQL.close();


    }
}
