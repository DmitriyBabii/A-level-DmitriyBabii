package com.alevel.hw10;

import com.alevel.hw10.models.*;

public class Main {
    public static void main(String[] args) {
        PassengerCar passengerCar = new PassengerCar(Series.AA, 123, Color.BLACK);

        Truck truck = new Truck(Series.AX, 124, Color.GREEN);

        passengerCar.addPassenger();
        passengerCar.addPassenger();
        passengerCar.addPassenger();
        passengerCar.addPassenger();

        System.out.println(passengerCar.getTraffic());
        System.out.println(truck.getTraffic());

        Recovery car = new PassengerCar(Series.AX, 242, Color.RED);
        car.refuel();

        Recovery recCar1 = new Recovery() {
            @Override
            public void refuel() {
                System.out.println("Refuel!");
            }
        };

        //lambda
        Recovery recCar2 = () -> System.out.println("Refuel!");
    }
}
