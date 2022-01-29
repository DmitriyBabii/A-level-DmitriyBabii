package com.alevel.hw24.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {
    private static int countDevice = 0;

    @Id
    @GeneratedValue
    private int idDevice;
    @Column
    private DeviceType type;
    @Column
    private String nameModel;
    @Column
    private int price;
    @Column
    private Date releaseDate;
    @Column
    private String description;
    @Column
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    public Device(DeviceType type, String nameModel, int price, Date releaseDate, String description,
                  boolean availability, Factory factory) {
        this.idDevice = ++countDevice;
        this.type = type;
        this.nameModel = nameModel;
        this.price = price;
        this.releaseDate = releaseDate;
        this.description = description;
        this.availability = availability;
        this.factory = factory;
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
                    rand.nextInt(50000),
                    Date.valueOf(LocalDate.now()),
                    "Some description",
                    true,
                    factories[count]);
        }
        return devices;
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
                ", idFactory=" + factory +
                "\n";
    }
}