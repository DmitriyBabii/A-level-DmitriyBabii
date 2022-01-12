package com.alevel.hw23.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

@Getter
public class Device {
    private static int countDevice = 0;

    private int idDevice;
    private DeviceType type;
    private String nameModel;
    private int price;
    private Date releaseDate;
    private String description;
    private boolean availability;
    private int idFactory;

    public Device(DeviceType type, String nameModel, int price, Date releaseDate, String description,
                  boolean availability, Factory factory) {
        this.idDevice = ++countDevice;
        this.type = type;
        this.nameModel = nameModel;
        this.price = price;
        this.releaseDate = releaseDate;
        this.description = description;
        this.availability = availability;
        this.idFactory = factory.getIdFactory();
    }

    public Device(int idDevice, DeviceType type, String nameModel, int price, Date releaseDate, String description,
                  boolean availability, int idFactory) {
        this.idDevice = idDevice;
        this.type = type;
        this.nameModel = nameModel;
        this.price = price;
        this.releaseDate = releaseDate;
        this.description = description;
        this.availability = availability;
        this.idFactory = idFactory;
    }

    public static Device[] createDevices(Factory... factories) {
        if (factories == null) {
            return null;
        }
        Random rand = new Random();
        Device[] devices = new Device[factories.length * 2];
        for (int i = 0, count = 0; i < devices.length; i++) {
            if (i != 0 && i % 2 == 0) {
                count++;
            }
            devices[i] = new Device(DeviceType.values()[rand.nextInt(DeviceType.values().length)],
                    "Model" + (Device.countDevice + 1),
                    Math.abs(rand.nextInt()),
                    Date.valueOf(LocalDate.now()),
                    "Some description",
                    true,
                    factories[count]);
        }
        return devices;
    }

    public static void setCountDevice(int countDevice) {
        Device.countDevice = countDevice;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "idDevice=" + idDevice +
                ", type=" + type +
                ", nameModel='" + nameModel + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                ", availability=" + availability +
                ", idFactory=" + idFactory +
                "\n";
    }
}
