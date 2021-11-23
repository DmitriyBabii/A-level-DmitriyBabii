package com.alevel.hw10.models;

public abstract class Car implements Recovery {
    //liters per 100 kilometers
    protected final static int GAS_MILEAGE = 11;

    protected Series series;
    protected int year;
    protected Color color;
    protected int fuel;

    protected Car(Series series, int year, Color color, int fuel) {
        this.series = series;
        this.year = year;
        this.color = color;
        this.fuel = fuel;
    }

    protected double startTraffic() {
        return (fuel * 100d) / GAS_MILEAGE;
    }

    public String getTraffic() {
        return String.format("%s covered %f kilometers at a flow rate of %d liters.\n",
                this, startTraffic(), GAS_MILEAGE);
    }

}
