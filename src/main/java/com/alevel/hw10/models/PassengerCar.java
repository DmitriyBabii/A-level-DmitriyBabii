package com.alevel.hw10.models;

import java.util.Arrays;

public class PassengerCar extends Car {
    private final static int MAX_FUEL = 45;

    private Passenger[] passengers;

    public PassengerCar(Series series, int year, Color color) {
        super(series, year, color, MAX_FUEL);
    }

    public void addPassenger() {
        if (passengers == null) {
            passengers = new Passenger[1];
            passengers[0] = new Passenger();
        } else if (passengers.length < 3) {
            Passenger[] tmp = new Passenger[passengers.length + 1];
            System.arraycopy(passengers, 0, tmp, 0, passengers.length);
            tmp[passengers.length] = new Passenger();
            passengers = tmp;
        }
    }

    @Override
    public void refuel() {
        this.fuel = MAX_FUEL;
    }

    @Override
    public String toString() {
        return "PassengerCar{\n" +
                "series = " + series +
                ", year = " + year +
                ", color = " + color +
                ", fuel = " + fuel +
                ", \npassengers = " + Arrays.toString(passengers) +
                "\n}";
    }
}
