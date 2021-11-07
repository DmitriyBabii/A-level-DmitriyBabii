package com.alevel.hw6;

class Car {
    private static final int MAX_FUEL = 100;

    final private Manufacturer manufacturer;
    private Engine engine;
    final private Color color;
    private int petrol;
    private int mileage; //kilometers

    public Car(Manufacturer manufacturer, String type, int power, Color color) {
        this(manufacturer, new Engine(type, power), color);
    }

    public Car(Manufacturer manufacturer, Engine engine, Color color) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.color = color;
        petrol = MAX_FUEL;
        mileage = 0;
    }

    public void startEngine() {
        if (petrol > 0) {
            engine.startEngine();
            System.out.printf("{%s} started the engine\n", manufacturer);
        }
    }

    public void stopEngine() {
        engine.stopEngine();
        System.out.printf("{%s} stopped the engine\n", manufacturer);
    }

    public boolean isEnoughPetrolLevel() {
        return petrol > 50;
    }

    public boolean isPetrolLevel(int level) {
        return petrol >= level;
    }

    public void run() {
        final int consumption = engine.getPower() / 10;
        if (!engine.isStart()) {
            this.startEngine();
        }
        System.out.println(manufacturer + " is on the way");
        while (petrol >= consumption && engine.isStart()) {
            petrol -= consumption;
            mileage += 100; //kilometers
        }
        this.stopEngine();
    }

    public void refueling() {
        petrol = MAX_FUEL;
    }

    @Override
    public String toString() {
        return "Car:\n" +
                "\tmanufacturer='" + manufacturer.getRussianName() + '\'' +
                "\n\tengine=" + engine +
                "\n\tcolor=" + color + '(' + color.getCode() + ')' +
                "\n\tpetrol=" + petrol +
                "\n\tmileage=" + mileage;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Color getColor() {
        return color;
    }

    public int getPetrol() {
        return petrol;
    }

}
