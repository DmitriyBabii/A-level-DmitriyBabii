package com.alevel.hw24.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {
    private static int countDevice = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Integer idDevice;
    @Column
    private DeviceType type;
    @Column
    private String nameModel;
    @Column
    private Integer price;
    @Column
    private Date releaseDate;
    @Column
    private String description;
    @Column
    private boolean availability;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn//(name = "factory_id")
    private Factory factory;

    private Device() {
    }

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