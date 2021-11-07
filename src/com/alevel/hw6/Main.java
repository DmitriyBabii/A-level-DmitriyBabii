package com.alevel.hw6;

import java.util.Random;

class Main {
    public static void main(String[] args) {
        Car[] cars = {
                new Car(Manufacturer.BMW, "Diesel", 120, Color.GREEN),
                new Car(Manufacturer.Audi, "Gas", 235, Color.RED),
                new Car(Manufacturer.Honda, "Gas", 200, Color.BLUE),
                new Car(Manufacturer.Ford, "Diesel", 335, Color.WHITE),
                new Car(Manufacturer.Mercedes_Benz, "Gas", 435, Color.YELLOW)
        };

        Random rand = new Random();
        for (Car car : cars) {
            if (rand.nextInt(3) == 1) {
                car.run();
            }
            Garage.checkCar(car);
            System.out.println();
        }
    }
}
