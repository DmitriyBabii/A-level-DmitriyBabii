package com.alevel.hw10.models;

public class Truck extends Car {
    private final static int MAX_FUEL = 125;

    public Truck(Series series, int year, Color color) {
        super(series, year, color, MAX_FUEL);
    }

    @Override
    protected double startTraffic() {
        return super.startTraffic() / 2;
    }

    @Override
    public String getTraffic() {
        return String.format("%s covered %f kilometers at a flow rate of %d liters.\n",
                this, startTraffic(), GAS_MILEAGE * 2);
    }

    @Override
    public void refuel() {
        this.fuel = MAX_FUEL;
    }

    @Override
    public String toString() {
        return "Truck{\n" +
                "series=" + series +
                ", year=" + year +
                ", color=" + color +
                ", fuel=" + fuel +
                "\n}";
    }
}
