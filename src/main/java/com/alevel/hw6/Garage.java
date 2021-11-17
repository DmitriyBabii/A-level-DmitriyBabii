package com.alevel.hw6;

class Garage {
    public static void checkCar(Car car) {
        System.out.println(car);
        if (!car.isEnoughPetrolLevel()) {
            System.out.println("Have no petrol enough!");
        } else if (car.getEngine().getPower() < 200) {
            System.out.println("Have no engine power enough!");
        } else {
            System.out.println("Everything is fine");
        }
    }
}
