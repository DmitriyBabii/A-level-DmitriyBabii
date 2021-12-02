package com.alevel.hw11.models;

public class TouchscreenPhone extends Phone {

    public TouchscreenPhone(String model, int year, Memory phoneMemory) {
        this(model, year, phoneMemory, false);
    }

    public TouchscreenPhone(String model, int year, Memory phoneMemory, boolean isBroken) {
        super(model, year, phoneMemory, isBroken);
        this.setType("TouchscreenPhone");
    }

    @Override
    public boolean call() {
        return pushScreen();
    }

    public boolean pushScreen() {
        return !this.isBroken();
    }
}
